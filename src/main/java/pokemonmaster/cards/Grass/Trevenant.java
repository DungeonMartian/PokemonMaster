package pokemonmaster.cards.Grass;

import com.evacipated.cardcrawl.mod.stslib.damagemods.DamageModifierManager;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.PiercingDamage;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Trevenant extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Trevenant",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 18;
    private static final int UPG_DAMAGE = 5;



    public Trevenant() {
        super(cardInfo,CustomTags.GRASS);
        setDamage(DAMAGE, UPG_DAMAGE);

        ExhaustiveField.ExhaustiveFields.baseExhaustive.set(this, 2);
        ExhaustiveField.ExhaustiveFields.exhaustive.set(this, 2);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackGrass.png","pokemonmaster/character/cardback/bg_attackGrass_p.png");
        DamageModifierManager.addModifier(this, new PiercingDamage());
    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p, 1), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Trevenant();
    }
}

