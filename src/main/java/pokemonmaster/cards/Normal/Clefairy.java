package pokemonmaster.cards.Normal;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Clefairy extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Clefairy",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);



    public Clefairy() {
        super(cardInfo,new Clefable(), new Clefable(),CustomTags.NORMAL);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillNormal.png","pokemonmaster/character/cardback/bg_skillNormal_p.png");
        setCostUpgrade(0);
    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        magicNumber = p.maxHealth/4;
        if (magicNumber < p.currentHealth) {
            addToBot(new DamageAction(p, new DamageInfo(p, magicNumber, DamageInfo.DamageType.HP_LOSS)));
            addToBot(new AddTemporaryHPAction(p, p, magicNumber));
        }
    }

    @Override
    public void applyPowers() {
        this.magicNumber=  AbstractDungeon.player.maxHealth/4;
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        super.applyPowers();
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
    }
    public void calculateCardDamage(AbstractMonster mo) {
        this.magicNumber=  AbstractDungeon.player.maxHealth/4;
        this.isMagicNumberModified = this.baseMagicNumber != this.magicNumber;
        super.calculateCardDamage(mo);
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Clefairy();
    }
}

