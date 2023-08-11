package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Ekans extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Ekans",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 3;

    private static final int UPG_MAGIC = 2;

    public Ekans() {
        super(cardInfo,new Arbok(),new Arbok(),CustomTags.DARK);
        setMagic(MAGIC,UPG_MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return false;
    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

    }

    @Override
    public void triggerWhenDrawn() {
        super.triggerWhenDrawn();
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                if (!monster.isDead && !monster.isDying) {
                    addToBot(new ApplyPowerAction(monster, AbstractDungeon.player, new StrengthPower(monster,  -magicNumber)));
                    addToBot(new ApplyPowerAction(monster, AbstractDungeon.player, new GainStrengthPower(monster,  magicNumber)));
                }
            }
        }
    }
    public void triggerOnManualDiscard() {
        addToBot(new EvolveActionCombat(this,AbstractDungeon.player.discardPile));
        addToBot(new ExhaustSpecificCardAction(this, AbstractDungeon.player.discardPile));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Ekans();
    }
}

