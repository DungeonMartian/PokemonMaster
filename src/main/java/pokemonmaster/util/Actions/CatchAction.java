package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.cards.Metal.Doublade;
import pokemonmaster.cards.Metal.Honedge;
import pokemonmaster.cards.StarterRelic.Act1.*;
import pokemonmaster.cards.StarterRelic.Act2.*;
import pokemonmaster.cards.StarterRelic.Act3.*;

public class CatchAction extends AbstractGameAction {

    private final AbstractCreature TARGET;
    private final DamageInfo info;

    public CatchAction (AbstractCreature target, DamageInfo info){
        this.info = info;
        this.TARGET = target;
        this.actionType = ActionType.DAMAGE;
        this.duration = 0.1F;
        this.damageType= DamageInfo.DamageType.HP_LOSS;
    }

    @Override
    public void update() {
        if (this.duration == 0.1F &&
                this.TARGET != null) {
            this.TARGET.damage(this.info);
            if (((this.TARGET).isDying || this.TARGET.currentHealth <= 0) && !this.TARGET.halfDead &&
                    !this.TARGET.hasPower("Minion")) {
                addToTop(new AddCardToDeckAction(AddThis(TARGET.id)));

            }

        }
        tickDuration();
    }
    public AbstractCard AddThis(String id){
        if (id == null){
            return new BookOfStabbing();
        }
        switch (id){
            case "FungiBeast":
                return new FungiBeast();
            case "SlaverBlue":
                return new SlaverBlue();
            case "SlaverRed":
                return new SlaverRed();
            case "Cultist":
                return new Cultist();
            case "JawWorm":
                return new JawWorm();
            case "GremlinFat":
                return new GremlinFat();
            case "GremlinWarrior":
                return new GremlinMad();
            case "GremlinTsundere":
                return new GremlinShield();
            case "GremlinThief":
                return new GremlinSneaky();
            case "GremlinWizard":
                return new GremlinWizard();
            case "Looter":
                return new Looter();
            case "FuzzyLouseNormal":
                return new LouseRed();
            case "FuzzyLouseDefensive":
                return new LouseGreen();
            case "SpikeSlime_S":
                return new SSlimeS();
            case "AcidSlime_S":
                return new ASlimeS();
            case "SpikeSlime_L":
                if (AbstractDungeon.getCurrRoom() instanceof com.megacrit.cardcrawl.rooms.MonsterRoomBoss)
                    return new SlimeBoss();
                else
                    return new SSlimeL();
            case "AcidSlime_L":
                if (AbstractDungeon.getCurrRoom() instanceof com.megacrit.cardcrawl.rooms.MonsterRoomBoss)
                    return new SlimeBoss();
                else
                    return new ASlimeL();
            case "SpikeSlime_M":
                if (AbstractDungeon.getCurrRoom() instanceof com.megacrit.cardcrawl.rooms.MonsterRoomBoss)
                    return new SlimeBoss();
                else
                    return new SSlimeM();
            case "AcidSlime_M":
                if (AbstractDungeon.getCurrRoom() instanceof com.megacrit.cardcrawl.rooms.MonsterRoomBoss)
                    return new SlimeBoss();
                else
                    return new ASlimeM();
            case "GremlinNob":
                return new GremlinNob();
            case "Sentry":
                return new Sentries();
            case "Lagavulin":
                return new Lagavulin();
            case "TheGuardian":
                return new Guardian();
            case "Hexaghost":
                return new Hexaghost();
            case "SlimeBoss":
                return new SlimeBoss();
            case "Byrd":
                return new Byrd();
            case "Chosen":
                return new Chosen();
            case "Centurion":
                return new Centurian();
            case "Healer":
                return new Mystic();
            case "Mugger":
                return new Mugger();
            case "Shelled Parasite":
                return new ShelledParasite();
            case "SnakePlant":
                return new SnakePlant();
            case "Snecko":
                return new Sneko();
            case "SphericGuardian":
                return new SphericGuardian();
            case "BanditChild":
                return new Pointy();
            case "BanditLeader":
                return new Romeo();
            case "BanditBear":
                return new Bear();
            case "BookOfStabbing":
                return new BookOfStabbing();
            case "SlaverBoss":
                return new Taskmaster();
            case "GremlinLeader":
                return new GremlinLeader();
            case "Champ":
                return new Champ();
            case "TheCollector":
                return new Collector();
            case "BronzeAutomaton":
                return new BronzeAutomaton();
            case "Nemesis":
                return new Nemesis();
            case "Reptomancer":
                return new Reptomancer();
            case "GiantHead":
                return new GiantHead();
            case "Darkling":
                return new Darkling();
            case "Exploder":
                return new ShapeExploder();
            case "Maw":
                return new Maw();
            case "Orb Walker":
                return new OrbWalker();
            case "Spiker":
                return new ShapeSpiker();
            case "Repulsor":
                return new ShapeRepulser();
            case "Serpent":
                return new SpireGrowth();
            case "Transient":
                return new Transient();
            case "WrithingMass":
                return new WrithingMass();
            case "TimeEater":
                return new TimeEater();
            case "AwakenedOne":
                return new AwakenedOne();
             case "Donu":
                 return new Donu();
             case "Deca":
                 return new Deca();
            case "SpireShield":
                return new Doublade();
            case "SpireSpear":
                return new Honedge();
            case "CorruptHeart":
                return new CorruptHeart();
            default:
                return new LouseGreen();
        }
    }
}
