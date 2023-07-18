package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
// import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
// import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.ModifyDamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;

// import com.megacrit.cardcrawl.powers.GainStrengthPower;
// import com.megacrit.cardcrawl.powers.StrengthPower;

// import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Toxin extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Toxin",
            -2,
            CardType.STATUS,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE_INCREASE = 2;

    private static final int DAMAGE = 1;

    public Toxin() {
        super(cardInfo);
        this.selfRetain = false;
        setDamage(DAMAGE);
        setMagic(DAMAGE_INCREASE,0);
        // tags.add(CustomTags.METAL);
        // tags.add(CustomTags.BAIT);
        this.misc =5;
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return false;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {


    }
    @Override
    public void triggerWhenDrawn() {
        addToBot(new DamageAction(AbstractDungeon.player, new DamageInfo(AbstractDungeon.player, damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ModifyDamageAction(this.uuid, this.magicNumber));
        // send to discard pile
        addToBot(new DiscardSpecificCardAction(this, null));
        // draw a card
        addToBot(new DrawCardAction(1));
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Toxin();
    }
}

