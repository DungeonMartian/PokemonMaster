package pokemonmaster.cards.Grass;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.FrailPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.ChoiceCards.BulletSeed;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Scovillain extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Scovillain",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int STRGAIN = 2;
    private static final int STRGAINUP = 1;



    public Scovillain() {
        super(cardInfo,CustomTags.GRASS);
        setMagic(STRGAIN, STRGAINUP);
 
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillGrass.png","pokemonmaster/character/cardback/bg_skillGrass_p.png");

    }

    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        AbstractCard s = (new BulletSeed()).makeCopy();
        AbstractPower STRPOW = AbstractDungeon.player.getPower(StrengthPower.POWER_ID);
        AbstractPower FRAILPOW = AbstractDungeon.player.getPower(FrailPower.POWER_ID);
        AbstractPower VULPOW = AbstractDungeon.player.getPower(VulnerablePower.POWER_ID);
        if (this.upgraded) {
            s.upgrade();
        }


        if (FRAILPOW != null) {
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(s));
        }


        if (VULPOW != null) {
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(s));
        }


        if (STRPOW != null) {
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(s));
        }

        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(s));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(s));
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p,magicNumber)));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Scovillain();
    }
}

