package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Mareanie extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Mareanie",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 10;
    private static final int WEAKEN= 1;
    private static final int UPG_WEAKEN= 1;


    public Mareanie() {
        super(cardInfo,new Toxapex(),new Toxapex(),CustomTags.WATER);
        setBlock(BLOCK);
        setMagic(WEAKEN,UPG_WEAKEN);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(monster, p, new WeakPower(monster,  magicNumber,false)));
                }
            }
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Mareanie();
    }
}

