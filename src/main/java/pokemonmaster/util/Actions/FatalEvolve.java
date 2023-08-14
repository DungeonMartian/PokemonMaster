package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.ExhaustBlurEffect;
import com.megacrit.cardcrawl.vfx.UpgradeShineEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardBrieflyEffect;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import pokemonmaster.CustomTags;

import java.util.ArrayList;

public class FatalEvolve extends AbstractGameAction {
    private final DamageInfo info;
    private AbstractCard theCard;
    private boolean EVOLVING = false;

    public FatalEvolve(AbstractCreature target, DamageInfo info) {
        this.info = info;
        setValues(target, info);
        this.actionType = AbstractGameAction.ActionType.DAMAGE;
        this.duration = Settings.ACTION_DUR_MED;
    }

    @Override
    public void update() {
        if (this.duration == Settings.ACTION_DUR_MED &&
                this.target != null) {
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AbstractGameAction.AttackEffect.NONE));
            this.target.damage(this.info);
            if ((this.target.isDying || this.target.currentHealth <= 0) && !this.target.halfDead &&
                    !this.target.hasPower("Minion")) {
                ArrayList<AbstractCard> possibleCards = new ArrayList<>();
                for (AbstractCard c : AbstractDungeon.player.masterDeck.group) {
                    if (c.hasTag(CustomTags.POKEMON )) {

                            if (c.canUpgrade() || c.cardsToPreview != null) {
                                possibleCards.add(c);
                            }

                    }
                }
                if (!possibleCards.isEmpty()) {
                    this.theCard = possibleCards.get(AbstractDungeon.miscRng.random(0, possibleCards.size() - 1));
                    if (this.theCard.cardsToPreview !=null ){
                        AbstractCard TOADD = this.theCard.cardsToPreview;
                        if (this.theCard.upgraded){
                            TOADD.upgrade();
                        }
                        AbstractDungeon.actionManager.addToTop(new AddCardToDeckAction(TOADD));
                        AbstractDungeon.player.masterDeck.removeCard(this.theCard);
                        EVOLVING = true;
                    }
                    else {
                        this.theCard.upgrade();
                        AbstractDungeon.player.bottledCardUpgradeCheck(this.theCard);
                        EVOLVING=false;
                    }

                }
            }
            //if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead())
            //    AbstractDungeon.actionManager.clearPostCombatActions();
        }
        tickDuration();
        if (this.isDone && this.theCard != null) {
            if (EVOLVING){
                AbstractDungeon.effectsQueue.add(new ExhaustBlurEffect(Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F));
                AbstractDungeon.topLevelEffectsQueue.add(new ShowCardBrieflyEffect(this.theCard.cardsToPreview.makeStatEquivalentCopy()));
            }
            if (!EVOLVING){
                AbstractDungeon.effectsQueue.add(new UpgradeShineEffect(Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F));
                AbstractDungeon.topLevelEffectsQueue.add(new ShowCardBrieflyEffect(this.theCard.makeStatEquivalentCopy()));
            }
            addToTop(new WaitAction(Settings.ACTION_DUR_MED));
        }
    }
    }


