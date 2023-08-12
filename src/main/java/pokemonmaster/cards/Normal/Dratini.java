package pokemonmaster.cards.Normal;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.ConstrictedPokemonPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Dratini extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Dratini",
            1,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 2;

    public Dratini() {
        super(cardInfo,new Dragonair(), new Dragonite(), CustomTags.NORMAL);

        setMagic(MAGIC,UPG_MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillNormal.png","pokemonmaster/character/cardback/bg_skillNormal_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(m, AbstractDungeon.player, new ConstrictedPokemonPower(m,p,magicNumber)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Dratini();
    }
}

