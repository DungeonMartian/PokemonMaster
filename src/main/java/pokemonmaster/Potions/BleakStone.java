package pokemonmaster.Potions;

import basemod.abstracts.CustomPotion;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.UmbreonGX;
import pokemonmaster.util.Actions.EvolveActionCombat;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class BleakStone extends CustomPotion {
    public static final String POTION_ID = makeID("BleakStone");

    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);
    //private AbstractCard TOREMOVE = null;
    ArrayList<AbstractCard> TOREMOVE = new ArrayList<>();
    public static final String NAME = potionStrings.NAME;

    public static final String[] DESCRIPTIONS = potionStrings.DESCRIPTIONS;

    public BleakStone() {
        super(NAME, POTION_ID, PotionRarity.COMMON, PotionSize.FAIRY, PotionColor.NONE);
        this.isThrown = false;
        this.targetRequired = false;
        this.labOutlineColor = Color.BLACK.cpy();
        this.tips.clear();
        this.tips.add(new PowerTip(this.name, this.description));
    }

    public void initializeData() {
        this.potency = getPotency();

            this.description = potionStrings.DESCRIPTIONS[0] + this.potency + potionStrings.DESCRIPTIONS[1];

        this.tips.clear();
        this.tips.add(new PowerTip(this.name, this.description));
    }

    public void use(AbstractCreature target) {
        addToBot(new SelectCardsInHandAction(this.potency, "evolve",true,true, card -> card.hasTag(CustomTags.POKEMON) && card.hasTag(CustomTags.DARK) || card.hasTag(CustomTags.EEVEE), cards -> {
            for (AbstractCard c2 : cards) {

                for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                    if (c.uuid == c2.uuid) {

                        if (c2.cardsToPreview !=null ){
                            AbstractDungeon.actionManager.addToBottom(new AddCardToDeckAction(c2.cardsToPreview));
                            //TOREMOVE = c;
                            TOREMOVE.add(c);
                            //AbstractDungeon.player.masterDeck.removeCard(c2);
                            //AbstractDungeon.player.masterDeck.removeCard(c);
                        }


                        if (c2.hasTag(CustomTags.EEVEE)){
                            AbstractDungeon.actionManager.addToBottom(new AddCardToDeckAction(new UmbreonGX()));
                            //TOREMOVE = c;
                            TOREMOVE.add(c);
                            //AbstractDungeon.player.masterDeck.removeCard(c2);
                            //AbstractDungeon.player.masterDeck.removeCard(c);
                        }
                        else {
                            c.upgrade();
                        }
                    }

                }
                if (c2.hasTag(CustomTags.EEVEE)){
                    AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(new UmbreonGX(), 1));
                    addToTop(new ExhaustSpecificCardAction(c2,AbstractDungeon.player.hand,true));
                }
                else {addToBot(new EvolveActionCombat(c2, "hand"));
                }
                if (TOREMOVE !=null) {
                    for (AbstractCard i : TOREMOVE) {
                        AbstractDungeon.player.masterDeck.removeCard(i);
                    }
                }
            }
        }));
    }

    public CustomPotion makeCopy() {
        return new BleakStone();
    }

    public int getPotency(int ascensionLevel) {
        return 1;
    }
}