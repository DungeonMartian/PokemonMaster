package pokemonmaster.cards.Fighting;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Stakataka extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Stakataka",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 6;
    private static final int UPG_BLOCK= 3;
    private static final int MAGIC = 10;
    private static final int UPG_MAGIC= 5;


    public Stakataka() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.FIGHTING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFighting.png","pokemonmaster/character/cardback/bg_skillFighting_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new GainBlockAction(p, p, block));
        if (p.currentHealth<=(p.maxHealth/2)){
           addToBot(new AddTemporaryHPAction(p,p, magicNumber));
           this.exhaust=true;
        }

    }
    public void triggerOnGlowCheck() {
        this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();

        if (AbstractDungeon.player.currentHealth<=(AbstractDungeon.player.maxHealth/2)) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Stakataka();
    }
}

