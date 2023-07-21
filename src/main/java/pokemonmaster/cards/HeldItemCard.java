package pokemonmaster.cards;

import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.StartupCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.powers.HeldItemPlayed;
import pokemonmaster.util.Actions.HeldItemAction;

public abstract class HeldItemCard extends BasePokemonCard implements StartupCard{
    public HeldItemCard(pokemonmaster.util.CardInfo cardInfo) {
        super(cardInfo);
    }

    // on startup
    public abstract void OnStartup();
    
    @Override
    public boolean atBattleStartPreDraw() {

        AbstractPower pow = AbstractDungeon.player.getPower(HeldItemPlayed.POWER_ID);
        // check if player has power that indicates a held item was played
        if (pow == null || pow.amount == 0) {
            OnStartup();
            // add power that indicates a held item was played
            addToBot(new HeldItemAction(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new pokemonmaster.powers.HeldItemPlayed(AbstractDungeon.player, 1))));
        }
        addToBot(new ExhaustSpecificCardAction(this, AbstractDungeon.player.drawPile));
        return true;
    }
}
