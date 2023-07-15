package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Shiinotic extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Shiinotic",
            2,
            CardType.SKILL,
            CardTarget.SELF_AND_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 6;

    private static final int LULLDEBURFF = 1;
    private static final int LULLDEBURFFUP = 1;



    public Shiinotic() {
        super(cardInfo);
        setBlock(BLOCK);
        setMagic(LULLDEBURFF,LULLDEBURFFUP);
        tags.add(CustomTags.GRASS);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (AbstractMonster mblock : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            if (!mblock.isDeadOrEscaped() && mblock.getIntentBaseDmg() >= 0) {
                addToBot(new GainBlockAction(p, p, mblock.getIntentDmg()));
            }
        }

        addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));
        addToBot(new ApplyPowerAction(m, p, new StrengthPower(m, -this.magicNumber), -this.magicNumber));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Shiinotic();
    }
}

