package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.IntermediateEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Gloom extends IntermediateEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Gloom",
            0,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 5;
    private static final int VULNE = 2;


    public Gloom() {
        super(cardInfo,new Vileplume(),CustomTags.GRASS);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(VULNE);
        this.isMultiDamage = true;

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackGrass.png","pokemonmaster/character/cardback/bg_attackGrass_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p,magicNumber,false)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Gloom();
    }
}

