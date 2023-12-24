package pokemonmaster.cards.Base;

import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.BetterDrawPileToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class EeveeGX extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "EeveeGX",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int EEVEESEEK = 2;
    private static final int EEVEEUP = 1;


    private float rotationTimer;
    private int previewIndex = 0;
    protected float getRotationTimeNeeded() {
        return 2.0F;
    }
    private final ArrayList<AbstractCard> cardToPreview = new ArrayList<>();

    public EeveeGX() {
        super(cardInfo);
        this.exhaust = true;
        tags.add(CustomTags.SPECIALEVOLVE);
        tags.add(CustomTags.EEVEE);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.NORMAL);
        setMagic(EEVEESEEK, EEVEEUP);
        this.cardToPreview.add(new EspeonGX());
        this.cardToPreview.add(new FlareonGX());
        this.cardToPreview.add(new GlaceonGX());
        this.cardToPreview.add(new JolteonGX());
        this.cardToPreview.add(new LeafeonGX());
        this.cardToPreview.add(new UmbreonGX());


    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new BetterDrawPileToHandAction(this.magicNumber,true));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));



            }
    @Override
    public void update() {
        super.update();
        if (!cardToPreview.isEmpty()) {
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
    public void applyPowers() {
        this.cardsToPreview = null;
    }

    @Override
    public float calculateModifiedCardDamage(AbstractPlayer player, float tmp) {
        this.cardsToPreview = null;
        return super.calculateModifiedCardDamage(player, tmp);
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
        return new EeveeGX();
    }
}

