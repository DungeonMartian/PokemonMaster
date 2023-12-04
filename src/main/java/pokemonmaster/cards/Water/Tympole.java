package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.RoundPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Tympole extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Tympole",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 1;
    private static final int UPG_DAMAGE = 1;
    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;


    public Tympole() {
        super(cardInfo,new Palpitoad(), new Seismitoad(), CustomTags.WATER);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.ROUND);
        tags.add(CustomTags.BAIT);
        this.isMultiDamage = true;
        this.misc = 20;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackWater.png","pokemonmaster/character/cardback/bg_attackWater_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        addToBot(new ApplyPowerAction(p, p, new RoundPower(p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Tympole();
    }
}

