package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.PoisonPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Gulpin extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Gulpin",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC =1;
    private static final int UPG_MAGIC= 1;



    public Gulpin() {
        super(cardInfo,new Swalot(),new Swalot(),CustomTags.DARK);
        setMagic(MAGIC,UPG_MAGIC);

        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.BAIT);
        this.misc=-25;

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");
    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(monster, p, new PoisonPower(monster, p, magicNumber), magicUpgrade));
                    AbstractPower pow = monster.getPower(PoisonPower.POWER_ID);
                    if (pow != null) {
                        addToBot(new GainBlockAction(p, p, pow.amount));
                    }
                }
            }
        }
        addToBot(new GainBlockAction(p, p, block));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Gulpin();
    }
}

