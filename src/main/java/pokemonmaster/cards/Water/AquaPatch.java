package pokemonmaster.cards.Water;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedBluePower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class AquaPatch extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "AquaPatch",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);





    public AquaPatch() {
        super(cardInfo);
        setCostUpgrade(0);
        tags.add(CustomTags.WATER);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.player.discardPile.isEmpty()) {
            addToTop(new SelectCardsAction(AbstractDungeon.player.discardPile.group, 1, "Choose card to exhaust", (cards) -> {
                for (AbstractCard c : cards) {
                    AbstractDungeon.player.discardPile.moveToExhaustPile(c);
                }
            }));
        }
        addToBot(new ApplyPowerAction(p, p, new EnergizedBluePower(p, 1)));
        addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p, 1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new AquaPatch();
    }
}

