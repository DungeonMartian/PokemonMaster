package pokemonmaster.util.Actions;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Slimed;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.RareCandy;
import pokemonmaster.cards.Base.UltraBall;
import pokemonmaster.cards.Dark.Overqwil;
import pokemonmaster.cards.Dark.Qwilfish;
import pokemonmaster.cards.Metal.Magnet;
import pokemonmaster.cards.Metal.MetalCoreBarrier;
import pokemonmaster.cards.Psychic.Dragalge;
import pokemonmaster.cards.Psychic.MirageGate;
import pokemonmaster.cards.Psychic.Skrelp;
import pokemonmaster.cards.Water.*;
import pokemonmaster.cards.Water.FishingCards.*;
import pokemonmaster.relics.SharkBait;

import java.util.ArrayList;

public class FishAction extends AbstractGameAction {

    public int BAIT =0;
    public int POWER;
    public int FIRSTNUM = 0;
    public int NEWFISHPOWER = 0;
    public boolean TODO = true;
    public FishAction(int FISHING) {
        this.POWER = FISHING;
        TODO =false;
    }


    public FishAction(int FISH, int FISHING) {
        this.POWER = FISHING;
        this.BAIT = FISH;
        TODO =false;
    }

    @Override
    public void update() {
        ArrayList<AbstractCard> FISHMONS = new ArrayList<>();
        FISHMONS.add(new Cursola());
        FISHMONS.add(new Slimed());
        FISHMONS.add(new Magnet());
        FISHMONS.add(new UltraBall());
        FISHMONS.add(new Chinchou());
        FISHMONS.add(new RareCandy());
        FISHMONS.add(new MetalCoreBarrier());
        FISHMONS.add(new OldRod());
        FISHMONS.add(new MirageGate());
        FISHMONS.add(new Revive());
        FISHMONS.add(new Qwilfish());
        FISHMONS.add(new Mareanie());
        FISHMONS.add(new Skrelp());
        FISHMONS.add(new Wailmer());
        FISHMONS.add(new Luvdisc());
        FISHMONS.add(new ShiningMagikarp());
        FISHMONS.add(new GoldFish());
        FISHMONS.add(new SharpedoEX());
        FISHMONS.add(new Toxapex());
        FISHMONS.add(new Wailord());
        FISHMONS.add(new Lanturn());
        FISHMONS.add(new Overqwil());
        FISHMONS.add(new Dragalge());
        FISHMONS.add(new RedGyarados());

        for (AbstractCard t : AbstractDungeon.player.hand.group) {
            if (t.hasTag(CustomTags.BAIT)) {
                TODO = true;
            }
        }
        if (TODO) {
            addToTop(new SelectCardsInHandAction(1, "exhaust", false, true, card -> card.hasTag(CustomTags.BAIT), abstractCards -> {
                for (AbstractCard i : abstractCards) {
                    this.BAIT += i.misc;
                    addToBot(new ExhaustSpecificCardAction(i, AbstractDungeon.player.hand));

                }
                String SHARKBAIT = SharkBait.ID;
                if (AbstractDungeon.player.hasRelic(SHARKBAIT)) {
                    this.BAIT += 15;
                }

                NEWFISHPOWER = (this.POWER + this.BAIT);



                FIRSTNUM = (int) Math.floor(Math.random() * (NEWFISHPOWER - (this.BAIT * 0.006) + 1) + (this.BAIT * 0.006));

                int CARD1 = (int) Math.floor(Math.random() * ((FISHMONS.size() * (FIRSTNUM * .01)) - (FISHMONS.size() * (this.BAIT * 0.006)) + 1) + (FISHMONS.size() * (this.BAIT * 0.006)));
                int CARD2 = (int) Math.floor(Math.random() * ((FISHMONS.size() * (FIRSTNUM * .01)) - (FISHMONS.size() * (this.BAIT * 0.006)) + 1) + (FISHMONS.size() * (this.BAIT * 0.006)));
                int CARD3 = (int) Math.floor(Math.random() * ((FISHMONS.size() * (FIRSTNUM * .01)) - (FISHMONS.size() * (this.BAIT * 0.006)) + 1) + (FISHMONS.size() * (this.BAIT * 0.006)));
                if (CARD1 >= FISHMONS.size()) {
                    CARD1 = FISHMONS.size() - 1;
                }
                if (CARD2 >= FISHMONS.size()) {
                    CARD2 = FISHMONS.size() - 1;
                }
                if (CARD3 >= FISHMONS.size()) {
                    CARD3 = FISHMONS.size() - 1;
                }

                if (CARD1 < 0) {
                    CARD1 = 0;
                }
                if (CARD2 < 0) {
                    CARD2 = 0;
                }
                if (CARD3 < 0) {
                    CARD3 = 0;
                }

                ArrayList<AbstractCard> FISHING = new ArrayList<>();
                AbstractCard a = (FISHMONS.get(Integer.valueOf(CARD1)));
                if (a.cost > 0) {
                    a.setCostForTurn(0);
                }
                a.isCostModifiedForTurn = true;
                FISHING.add(a);

                AbstractCard b = (FISHMONS.get(Integer.valueOf(CARD2)));
                if (b.cost > 0) {
                    b.setCostForTurn(0);
                    b.isCostModifiedForTurn = true;
                }
                FISHING.add(b);

                AbstractCard c = (FISHMONS.get(Integer.valueOf(CARD3)));
                if (c.cost > 0) {
                    c.setCostForTurn(0);
                    c.isCostModifiedForTurn = true;
                }
                FISHING.add(c);

                addToBot(new EasyModalChoiceAction(FISHING, 1, "Fish"));
            }));


        }
        else {
            String SHARKBAIT = SharkBait.ID;
            if (AbstractDungeon.player.hasRelic(SHARKBAIT)) {
                this.BAIT += 15;
            }

            NEWFISHPOWER = (this.POWER + this.BAIT);



            FIRSTNUM = (int) Math.floor(Math.random() * (NEWFISHPOWER - (this.BAIT * 0.005) + 1) + (this.BAIT * 0.005));

            int CARD1 = (int) Math.floor(Math.random() * ((FISHMONS.size() * (FIRSTNUM * .01)) - (FISHMONS.size() * (this.BAIT * 0.005)) + 1) + (FISHMONS.size() * (this.BAIT * 0.005)));
            int CARD2 = (int) Math.floor(Math.random() * ((FISHMONS.size() * (FIRSTNUM * .01)) - (FISHMONS.size() * (this.BAIT * 0.005)) + 1) + (FISHMONS.size() * (this.BAIT * 0.005)));
            int CARD3 = (int) Math.floor(Math.random() * ((FISHMONS.size() * (FIRSTNUM * .01)) - (FISHMONS.size() * (this.BAIT * 0.005)) + 1) + (FISHMONS.size() * (this.BAIT * 0.005)));
            if (CARD1 >= FISHMONS.size()) {
                CARD1 = FISHMONS.size() - 1;
            }
            if (CARD2 >= FISHMONS.size()) {
                CARD2 = FISHMONS.size() - 1;
            }
            if (CARD3 >= FISHMONS.size()) {
                CARD3 = FISHMONS.size() - 1;
            }

            if (CARD1 < 0) {
                CARD1 = 0;
            }
            if (CARD2 < 0) {
                CARD2 = 0;
            }
            if (CARD3 < 0) {
                CARD3 = 0;
            }

            ArrayList<AbstractCard> FISHING = new ArrayList<>();
            AbstractCard a = (FISHMONS.get(Integer.valueOf(CARD1)));
            if (a.cost > 0) {
                a.setCostForTurn(0);
            }
            a.isCostModifiedForTurn = true;
            FISHING.add(a);

            AbstractCard b = (FISHMONS.get(Integer.valueOf(CARD2)));
            if (b.cost > 0) {
                b.setCostForTurn(0);
                b.isCostModifiedForTurn = true;
            }
            FISHING.add(b);

            AbstractCard c = (FISHMONS.get(Integer.valueOf(CARD3)));
            if (c.cost > 0) {
                c.setCostForTurn(0);
                c.isCostModifiedForTurn = true;
            }
            FISHING.add(c);

            addToBot(new EasyModalChoiceAction(FISHING, 1, "Fish"));
        }
        this.isDone = true;
    }

}
