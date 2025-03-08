package pokemonmaster.cards.Base;

import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.StarterRelic.Pokeball;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;
import java.util.function.Consumer;

import static pokemonmaster.PokemonMasterMod.makeID;

public class RotomDex extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RotomDex",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int SCRY = 3;
    private static final int SCRYUP= 2;
    private float rotationTimer;
    private int previewIndex = 0;
    protected float getRotationTimeNeeded() {
        return 2.0F;
    }
    private final ArrayList<AbstractCard> cardToPreview = new ArrayList<>();

    public RotomDex() {
        super(cardInfo);
        setMagic(SCRY, SCRYUP);
        this.exhaust=true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ScryAction(this.magicNumber));
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
            if (!m.isDeadOrEscaped() && AbstractDungeon.getCurrRoom() instanceof MonsterRoomBoss && (m.id.equals("AcidSlime_L") || m.id.equals("SpikeSlime_L") || m.id.equals("SpikeSlime_M") || m.id.equals("AcidSlime_M"))) {
                    if (!this.cardToPreview.add(Pokeball.AddThis("SlimeBoss"))) {
                        this.cardToPreview.add(Pokeball.AddThis("SlimeBoss"));
                    }
                }
            if (!this.cardToPreview.contains(Pokeball.AddThis(m.id))) {
                this.cardToPreview.add(Pokeball.AddThis(m.id));
            }
            }

        }



    @Override
    public AbstractCard makeCopy() { //Optional
        return new RotomDex();
    }
}

