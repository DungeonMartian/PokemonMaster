package pokemonmaster.cards.Dark;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class LiepardEX extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "LiepardEX",
            1,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 8;
    private static final int UPG_MAGIC= 4;



    public LiepardEX() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.DARK);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m, p, new StrengthPower(m, 3)));
        addToBot(new AddTemporaryHPAction(p, p,magicNumber));
        addToBot(new ApplyPowerAction(p, p, new Prized(p, 1)));
        if (m != null && m.getIntentBaseDmg() >= 0) {
            addToBot(new StunMonsterAction(m, p));
            this.exhaust=true;
        }



    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new LiepardEX();
    }
}

