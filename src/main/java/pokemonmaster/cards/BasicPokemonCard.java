package pokemonmaster.cards;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
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
    private final PokemonCard nextEvolution;
    private final PokemonCard finalEvolution;
    private AbstractCard NextEvo;
    private boolean isDuplicate = false;


    public BasicPokemonCard(CardInfo cardinfo, PokemonCard nextEvolution, PokemonCard finalEvolution, CardTags pokemonType) {
        super(cardinfo, pokemonType);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.nextEvolution = nextEvolution;
        this.finalEvolution = finalEvolution;
        // if this,finalEvolution is not None
        if (this.finalEvolution != null) {


            if (this.finalEvolution.name != this.nextEvolution.name){
                NextEvo = this.nextEvolution;
                MultiCardPreview.add((AbstractCard)this, true,  (AbstractCard)NextEvo);
                //System.out.println("help " + finalEvolution + " me" + nextEvolution);
            }

                this.cardsToPreview = this.finalEvolution;


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
            AbstractCard TOEVOLVE =this.nextEvolution.makeCopy();
            if (this.isCostModified | this.isCostModifiedForTurn){
                if (this.isCostModified){

                    if (this.cost == 0){
                        TOEVOLVE.cost = 0;
                        TOEVOLVE.costForTurn = 0;
                    }
                    else {
                        int NEW = this.baseCost -this.cost;
                        TOEVOLVE.costForTurn -= NEW;
                        TOEVOLVE.cost -=  NEW;
                    }
                    TOEVOLVE.isCostModified = true;
                }
                if (this.isCostModifiedForTurn){

                    if (this.costForTurn == 0){
                        TOEVOLVE.costForTurn = 0;
                    }
                    else{
                        int NEW = this.baseCost - this.cost;
                        TOEVOLVE.costForTurn -= NEW;
                    }
                    TOEVOLVE.isCostModifiedForTurn=true;
                }
            }
            if (this.upgraded){
                TOEVOLVE.upgrade();
            }
            addToBot(new MakeTempCardInDiscardAction(TOEVOLVE, 1));
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



    public void upgrade() {
        this.cardsToPreview.upgrade();
        NextEvo.upgrade();
        super.upgrade();
    }

    // define abstract method onUse
    public abstract void onUse(AbstractPlayer p, AbstractMonster m);
}

