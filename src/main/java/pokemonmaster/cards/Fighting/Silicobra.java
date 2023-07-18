package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Silicobra extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Silicobra",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK= 3;
    private static final int SILIDEX= 1;



    public Silicobra() {
        super(cardInfo,new Sandacona(),new Sandacona(),CustomTags.FIGHTING);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(SILIDEX);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFighting.png","pokemonmaster/character/cardback/bg_skillFighting_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p,1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Silicobra();
    }
}

