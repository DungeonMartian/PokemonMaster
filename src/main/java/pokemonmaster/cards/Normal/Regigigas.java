package pokemonmaster.cards.Normal;

import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.StartupCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.Dragon.Regidrago;
import pokemonmaster.cards.Fighting.Regirock;
import pokemonmaster.cards.Lightning.Regieleki;
import pokemonmaster.cards.Metal.Registeel;
import pokemonmaster.cards.Water.Regice;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.SlowStart;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Regigigas extends BasePokemonCard implements StartupCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Regigigas",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 100;

    private float rotationTimer;
    private int previewIndex = 0;
    protected float getRotationTimeNeeded() {
        return 1.0F;
    }
    private final ArrayList<AbstractCard> cardToPreview = new ArrayList<>();

    public Regigigas() {
        super(cardInfo);
        setDamage(DAMAGE);
        tags.add(CustomTags.NORMAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.REGIGIGAS);
        tags.add(CardTags.HEALING);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackNormal.png","pokemonmaster/character/cardback/bg_attackNormal_p.png");
        this.cardToPreview.add(new Registeel());
        this.cardToPreview.add(new Regirock());
        this.cardToPreview.add(new Regieleki());
        this.cardToPreview.add(new Regice());
        this.cardToPreview.add(new Regidrago());




    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));



    }

    @Override
    public void upgrade() {
        for(int i = 0; i < cardToPreview.size(); i++){
            cardToPreview.get(i).upgrade();
        }
        super.upgrade();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Regigigas();
    }
    @Override
    public void update() {
        super.update();
        if (!cardToPreview.isEmpty() ) {
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
            else{
                this.cardsToPreview = null;
            }
        }

    }

    @Override
    public boolean atBattleStartPreDraw() {
        AbstractCard A = new Registeel();
        AbstractCard B = new Regirock();
        AbstractCard C = new Regieleki();
        AbstractCard D = new Regice();
        AbstractCard E = new Regidrago();

        if (this.upgraded) {
            A.upgrade();
            B.upgrade();
            C.upgrade();
            D.upgrade();
            E.upgrade();
        }

        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(A, 1, true, false));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(B, 1, true, false));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(C, 1, true, false));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(D, 1, true, false));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(E, 1, true, false));
        addToBot(new ExhaustSpecificCardAction(this, AbstractDungeon.player.drawPile));
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new SlowStart(AbstractDungeon.player,magicNumber)));
        return true;
    }
}

