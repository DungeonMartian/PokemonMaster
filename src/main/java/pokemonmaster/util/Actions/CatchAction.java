package pokemonmaster.util.Actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import pokemonmaster.cards.Dark.Arbok;
import pokemonmaster.cards.Dragon.DragoniteV;
import pokemonmaster.cards.Fighting.Diglett;
import pokemonmaster.cards.Fighting.Dugtrio;
import pokemonmaster.cards.Fighting.MachoBrace;
import pokemonmaster.cards.Fighting.Onix;
import pokemonmaster.cards.Fire.Vulpix;
import pokemonmaster.cards.Metal.Doublade;
import pokemonmaster.cards.Metal.Honedge;
import pokemonmaster.cards.Normal.Zigzagoon;
import pokemonmaster.cards.Psychic.Gastly;
import pokemonmaster.cards.Psychic.Gengar;
import pokemonmaster.cards.Psychic.Haunter;
import pokemonmaster.cards.StarterRelic.Act1.*;
import pokemonmaster.cards.StarterRelic.Act2.*;
import pokemonmaster.cards.StarterRelic.Act3.*;
import pokemonmaster.cards.Water.Cetitan;

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
            case "pokeRegions:ArbokEnemy":
                return new Arbok();
            case "pokeRegions:CloysterEnemy": //finish
                return new Cetitan();
            case "pokeRegions:DigletEnemy":
                return new Diglett();
            case "pokeRegions:DragoniteEnemy":
                return new DragoniteV();
            case "pokeRegions:DugtrioEnemy":
                return new Dugtrio();
            case "pokeRegions:GastlyEnemy":
                return new Gastly();
            case "pokeRegions:GengarEnemy":
                return new Gengar();
            case "pokeRegions:GolemEnemy"://finish
                return new Onix();
            case "pokeRegions:HaunterEnemy":
                return new Haunter();
            case "pokeRegions:MachampEnemy"://finish
                return new MachoBrace();
            case "pokeRegions:RattataEnemy"://finish
                return new Zigzagoon();
            case "pokeRegions:RhyhornEnemy"://finish
                return new Onix();
            case "pokeRegions:VulpixEnemy":
                return new Vulpix();
            default:
                return new LouseGreen();
        }
    }
}
