package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.Actions.FlareonAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class FlareonGX extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FlareonGX",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 3;
    private static final int MAGIC = 5;
    private static final int UPG_MAGIC = 1;


    public FlareonGX() {
        super(cardInfo);

        tags.add(CustomTags.WATER);
        tags.add(CustomTags.POKEMON);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {


        addToBot(new FlareonAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), this.magicNumber));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));


            }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new FlareonGX();
    }
}

