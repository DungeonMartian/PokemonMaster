package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class TapuKokoGX extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "TapuKokoGX",
            3,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    public TapuKokoGX() {
        super(cardInfo);
        setCostUpgrade(2);
        tags.add(CustomTags.LIGHTNING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.baseMagicNumber=0;
        this.exhaust=true;
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");
        this.rawDescription = cardStrings.DESCRIPTION;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        addToBot(new DrawCardAction(magicNumber));
        addToBot(new GainEnergyAction(magicNumber));
    }


    @Override
    public void applyPowers() {
        this.magicNumber= AbstractDungeon.actionManager.cardsPlayedThisTurn.size();
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        super.applyPowers();
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
    }
    public void calculateCardDamage(AbstractMonster mo) {
        this.magicNumber= AbstractDungeon.actionManager.cardsPlayedThisTurn.size();
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        super.calculateCardDamage(mo);
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
    }


    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        initializeDescription();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new TapuKokoGX();
    }
}

