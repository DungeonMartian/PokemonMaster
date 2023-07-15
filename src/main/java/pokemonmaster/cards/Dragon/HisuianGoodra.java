package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BufferPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class HisuianGoodra extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "HisuianGoodra",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DLESS = 1;
    private static final int DLESSUP= 1;



    public HisuianGoodra() {
        super(cardInfo);
        setMagic(DLESS, DLESSUP);
        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDragon.png","pokemonmaster/character/cardback/bg_skillDragon_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new BufferPower(p,magicNumber)));

        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new Goomy(), 1, true, true));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new HisuianGoodra();
    }
}

