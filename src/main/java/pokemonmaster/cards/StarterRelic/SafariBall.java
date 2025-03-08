package pokemonmaster.cards.StarterRelic;

import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.FleetingField;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.CatchAction;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;
import java.util.function.Consumer;

import static pokemonmaster.PokemonMasterMod.makeID;

public class SafariBall extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SafariBall",
            0,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int CULT = 20;
    private float rotationTimer;
    private int previewIndex = 0;
    protected float getRotationTimeNeeded() {
        return 1.0F;
    }
    private final ArrayList<AbstractCard> cardToPreview = new ArrayList<>();

    public SafariBall() {
        super(cardInfo);
        this.purgeOnUse = true;
        setDamage(CULT);
        this.damageType= DamageInfo.DamageType.HP_LOSS;
        this.damageTypeForTurn= DamageInfo.DamageType.HP_LOSS;
        FleetingField.fleeting.set(this, true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m.currentHealth <=20) {
            //addToBot(new DamageAction(m, new DamageInfo(p, 10, DamageInfo.DamageType.HP_LOSS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
            addToBot(new CatchAction(m,new DamageInfo(p, this.damage, this.damageTypeForTurn)));
           //if (((m).isDying || m.currentHealth <= 0) && !m.halfDead &&
           //        !m.hasPower("Minion")) {
           //    addToTop(new AddCardToDeckAction(AddThis(m.id)));
           //    addToBot(new MakeTempCardInDiscardAction(AddThis(m.id), 1));
           //}
        }

    }
    public static void forAllMonstersLiving(Consumer<AbstractMonster> consumer) {
        for (AbstractMonster m : getEnemies()) {
            consumer.accept(m);
        }
    }
    public static ArrayList<AbstractMonster> getEnemies() {
        ArrayList<AbstractMonster> monsters = new ArrayList<>(AbstractDungeon.getMonsters().monsters);
        monsters.removeIf(AbstractMonster::isDeadOrEscaped);
        return monsters;
    }
    @Override
    public void update() {
        super.update();
        if (!cardToPreview.isEmpty() && AbstractDungeon.actionManager.isEmpty()) {
            if (hb.hovered) {
                if (rotationTimer <= 0F) {
                    rotationTimer = getRotationTimeNeeded();
                    if (previewIndex == cardToPreview.size() - 1) {
                        previewIndex = 0;
                    } else {
                        previewIndex++;
                    }
                    if (previewIndex >= cardToPreview.size()){
                        previewIndex = cardToPreview.size()-1;
                    }
                    cardsToPreview = cardToPreview.get(previewIndex);
                } else {
                    rotationTimer -= Gdx.graphics.getDeltaTime();
                }
            }
        }
    }
    @Override
    public void applyPowers() {
        for (AbstractMonster m : getEnemies()) {
            if (!this.cardToPreview.contains(Pokeball.AddThis(m.id))) {
                this.cardToPreview.add(Pokeball.AddThis(m.id));
            }
            if (!m.isDeadOrEscaped() && AbstractDungeon.getCurrRoom() instanceof MonsterRoomBoss) {
                if (m.id.equals("AcidSlime_L") || m.id.equals("SpikeSlime_L") || m.id.equals("SpikeSlime_M") || m.id.equals("AcidSlime_M")) {
                    if (!this.cardToPreview.add(Pokeball.AddThis("SlimeBoss"))) {
                        this.cardToPreview.add(Pokeball.AddThis("SlimeBoss"));
                    }
                }
            }

        }}


    @Override
    public AbstractCard makeCopy() { //Optional
        return new SafariBall();
    }
}

