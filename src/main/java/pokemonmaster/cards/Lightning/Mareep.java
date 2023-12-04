package pokemonmaster.cards.Lightning;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.TakeDamagePower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Mareep extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Mareep",
            2,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int RECOIL = 6;
    private static final int UPG_RECOIL= -3;



    public Mareep() {
        super(cardInfo, new Flaaffy(), new Ampharos(), CustomTags.LIGHTNING);
        setMagic(RECOIL, UPG_RECOIL);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillLightning.png","pokemonmaster/character/cardback/bg_skillLightning_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new StunMonsterAction(m,p ));
        addToBot(new ApplyPowerAction(p, p, new TakeDamagePower(p,magicNumber)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Mareep();
    }
}

