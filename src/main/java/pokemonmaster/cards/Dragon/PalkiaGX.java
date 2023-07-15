package pokemonmaster.cards.Dragon;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class PalkiaGX extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "PalkiaGX",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE ,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);



    public PalkiaGX() {
        super(cardInfo);

        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDragon.png","pokemonmaster/character/cardback/bg_skillDragon_p.png");
        setCostUpgrade(1);
        this.exhaust=true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));

        this.magicNumber=p.hand.size();
        addToBot(new SelectCardsInHandAction(this.magicNumber, "Exhaust", true, true, c -> true, list -> {
            for (AbstractCard c : list) {
                addToBot(new ExhaustSpecificCardAction(c,p.hand,true));
                addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, 2)));
                addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p, 2)));
            }
            AbstractDungeon.player.hand.refreshHandLayout();
        }));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new PalkiaGX();
    }
}

