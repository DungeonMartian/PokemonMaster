package pokemonmaster.cards;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DuplicationPower;
import pokemonmaster.CustomTags;
import pokemonmaster.util.CardInfo;


public abstract class BasicPokemonCard extends PokemonCard {
    private PokemonCard nextEvolution;
    private PokemonCard finalEvolution;
    private boolean isDuplicate = false;
    public BasicPokemonCard(CardInfo cardinfo, PokemonCard nextEvolution, PokemonCard finalEvolution, CardTags pokemonType) {
        super(cardinfo, pokemonType);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.nextEvolution = nextEvolution;
        this.finalEvolution = finalEvolution;
        // if this,finalEvolution is not None
        if (this.finalEvolution != null) {
            this.cardsToPreview = this.finalEvolution.makeCopy();
        }
        // if this.nextEvolution is not None
        if (this.nextEvolution != null) {
            purgeOnUse = true;
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        onUse(p, m);
        // if this.nextEvolution is not None
        if (this.nextEvolution != null && !this.isDuplicate) {
            addToBot(new MakeTempCardInDiscardAction(this.nextEvolution.makeCopy(), 1));
        }

        if (!isDuplicate){
            AbstractPower pow = AbstractDungeon.player.getPower(DuplicationPower.POWER_ID);
            if (pow != null) {
                if (pow.amount == 0) {
                    addToTop(new RemoveSpecificPowerAction(pow.owner, pow.owner, pow));
                    applyPowers();
                }
                else{
                    addToTop(new ReducePowerAction(p, p, pow, 1));
                    applyPowers();
                }

                BasicPokemonCard tmp = (BasicPokemonCard) this.makeSameInstanceOf();
                tmp.isDuplicate = true;
                AbstractDungeon.player.limbo.addToTop(tmp);
                tmp.current_x = this.current_x;
                tmp.current_y = this.current_y;
                tmp.target_x = Settings.WIDTH / 2.0F - 300.0F * Settings.scale;
                tmp.target_y = Settings.HEIGHT / 2.0F;
                if (m != null)
                    tmp.calculateCardDamage(m);
                tmp.purgeOnUse = true;
                AbstractDungeon.actionManager.addCardQueueItem(new CardQueueItem(tmp, m, this.energyOnUse, true, true), false);

            }
        }

    }

    // define abstract method onUse
    public abstract void onUse(AbstractPlayer p, AbstractMonster m);
}

