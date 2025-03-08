package pokemonmaster.cards.StarterRelic;

import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.FleetingField;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.Base.EspeonGX;
import pokemonmaster.cards.Dark.Arbok;
import pokemonmaster.cards.Dark.CrobatV;
import pokemonmaster.cards.Dark.GalarianMoltres;
import pokemonmaster.cards.Dark.TyranitarV;
import pokemonmaster.cards.Dragon.*;
import pokemonmaster.cards.Fighting.*;
import pokemonmaster.cards.Fire.Hooh;
import pokemonmaster.cards.Fire.Magcargo;
import pokemonmaster.cards.Fire.Slugma;
import pokemonmaster.cards.Fire.Vulpix;
import pokemonmaster.cards.Grass.Breloom;
import pokemonmaster.cards.Grass.Tangrowth;
import pokemonmaster.cards.Grass.Tropius;
import pokemonmaster.cards.Lightning.AlolanGolem;
import pokemonmaster.cards.Lightning.Raikou;
import pokemonmaster.cards.Lightning.ToxtricityV;
import pokemonmaster.cards.Lightning.Zapdos;
import pokemonmaster.cards.Metal.*;
import pokemonmaster.cards.Normal.LugiaGX;
import pokemonmaster.cards.Normal.Slaking;
import pokemonmaster.cards.Normal.Zigzagoon;
import pokemonmaster.cards.Psychic.*;
import pokemonmaster.cards.StarterRelic.Act1.*;
import pokemonmaster.cards.StarterRelic.Act2.*;
import pokemonmaster.cards.StarterRelic.Act3.*;
import pokemonmaster.cards.Water.*;
import pokemonmaster.cards.Water.FishingCards.RedGyarados;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.CatchAction;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;
import java.util.function.Consumer;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Pokeball extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Pokeball",
            0,
            CardType.SKILL,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int CULT = 10;
    private float rotationTimer;
    private int previewIndex = 0;
    protected float getRotationTimeNeeded() {
        return 1.0F;
    }
    private final ArrayList<AbstractCard> cardToPreview = new ArrayList<>();

    public Pokeball() {
        super(cardInfo);
        this.purgeOnUse = true;
        setDamage(CULT);
        this.damageType= DamageInfo.DamageType.HP_LOSS;
        this.damageTypeForTurn= DamageInfo.DamageType.HP_LOSS;
        FleetingField.fleeting.set(this, true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m.currentHealth <=10) {
            addToBot(new CatchAction(m,new DamageInfo(p, this.damage, this.damageTypeForTurn)));

        }

    }
    public static void forAllMonstersLiving(Consumer<AbstractMonster> consumer) {
        for (AbstractMonster m : getEnemies()) {
            consumer.accept(m);
        }
    }
    public static ArrayList<AbstractMonster> getEnemies() {
        ArrayList<AbstractMonster> monsters = new ArrayList<>(AbstractDungeon.getMonsters().monsters);
        monsters.removeIf(AbstractMonster::isDeadOrEscaped);
        return monsters;
    }
    @Override
    public void update() {
        super.update();
        if (!cardToPreview.isEmpty() && AbstractDungeon.actionManager.isEmpty()) {
            if (hb.hovered) {
                if (rotationTimer <= 0F) {
                    rotationTimer = getRotationTimeNeeded();
                    if (previewIndex == cardToPreview.size() - 1) {
                        previewIndex = 0;
                    } else {
                        previewIndex++;
                    }
                    if (previewIndex >= cardToPreview.size()){
                        previewIndex = cardToPreview.size()-1;
                    }
                    cardsToPreview = cardToPreview.get(previewIndex);
                } else {
                    rotationTimer -= Gdx.graphics.getDeltaTime();
                }
            }
        }
    }
    @Override
    public void applyPowers() {
        for (AbstractMonster m : getEnemies()) {
                if (!this.cardToPreview.contains(AddThis(m.id))) {
                    this.cardToPreview.add(AddThis(m.id));
                }
                if (!m.isDeadOrEscaped() && AbstractDungeon.getCurrRoom() instanceof MonsterRoomBoss) {
                    if (m.id.equals("AcidSlime_L") || m.id.equals("SpikeSlime_L") || m.id.equals("SpikeSlime_M") || m.id.equals("AcidSlime_M")) {
                        if (!this.cardToPreview.add(AddThis("SlimeBoss"))) {
                            this.cardToPreview.add(AddThis("SlimeBoss"));
                    }
                }
            }

    }}

    public static AbstractCard AddThis(String id){
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
            case "pokeRegions:DigletEnemy":
                return new Diglett();
            case "pokeRegions:DragoniteEnemy":
                return new DragoniteV();
            case "pokeRegions:GastlyEnemy":
                return new Gastly();
            case "pokeRegions:HaunterEnemy":
                return new Haunter();
            case "pokeRegions:GengarEnemy":
                return new Gengar();

            //
            //
            case "pokeRegions:LunatoneEnemy": //finish
                return new Diancie();
            case "pokeRegions:SolrockEnemy": //finish
                return new Diancie();
            case "pokeRegions:PupitarEnemy": //finish
                return new TyranitarV();
            case "pokeRegions:": //finish
                return new TyranitarV();
            case "pokeRegions:AriadosOakley": //finish
                return new ToxtricityV();
            case "pokeRegions:VictreebelEnemy": //finish
                return new Tangrowth();
            case "pokeRegions:SwinubEnemy": //finish
                return new Slowpoke();
            case "pokeRegions:PiloswineEnemy": //finish
                return new Slowbro();
            case "pokeRegions:MewtwoEnemy": //finish
                return new MewEX();
            case "pokeRegions:GroudonEnemy": //finish
                return new Terrakion();
            case "pokeRegions:KyogreEnemy": //finish
                return new RedGyarados();
            case "pokeRegions:OmastarEnemy": //finish
                return new Chewtle();
            case "pokeRegions:KingdraEnemy": //finish
                return new Keldeo();
            case "pokeRegions:AzumarillEnemy": //finish
                return new Crawdaunt();
            case "pokeRegions:MantineEnemy": //finish
                return new Quagsire();
            case "pokeRegions:AlakazamEnemy": //finish
                return new TapuLele();
            case "pokeRegions:CloysterEnemy": //finish
                return new Cetitan();
            case "pokeRegions:GolemEnemy"://finish
                return new AlolanGolem();
            case "pokeRegions:MachampEnemy"://finish
                return new MachoBrace();
            case "pokeRegions:RattataEnemy"://finish
                return new Zigzagoon();
            case "pokeRegions:RhyhornEnemy"://finish
                return new JawWorm();
            case "pokeRegions:TrapinchEnemy"://finish
                return new FlygonV();
            case "pokeRegions:CaterpieEnemy"://finish
                return new LouseGreen();
            case "pokeRegions:WeedleEnemy"://finish
                return new LouseRed();
            case "pokeRegions:VulpixEnemy":
                return new Vulpix();
            case "pokeRegions:ArticunoEnemy":
                return new Articuno();
            case "pokeRegions:MoltresEnemy":
                return new GalarianMoltres();
            case "pokeRegions:ZapdosEnemy":
                return new Zapdos();
            case "pokeRegions:DiglettEnemy":
                return new Diglett();
            case "pokeRegions:DugtrioEnemy":
                return new Dugtrio();
            case "pokeRegions:CrobatEnemy":
                return new CrobatV();
            case "pokeRegions:HoOhEnemy":
                return new Hooh();
            case "pokeRegions:LanturnEnemy":
                return new Lanturn();
            case "pokeRegions:LugiaEnemy":
                return new LugiaGX();
            case "pokeRegions:MagcargoEnemy":
                return new Magcargo();
            case "pokeRegions:QuagsireEnemy":
                return new Quagsire();
            case "pokeRegions:RaikouEnemy":
                return new Raikou();
            case "pokeRegions:ScizorEnemy":
                return new Scizor();
            case "pokeRegions:SkarmoryEnemy":
                return new Skarmory();
            case "pokeRegions:SlugmaEnemy":
                return new Slugma();
            case "pokeRegions:SteelixEnemy":
                return new Steelix();
            case "pokeRegions:FlygonR":
                return new FlygonV();
            case "pokeRegions:RayquazaEnemy":
                return new Rayquaza();
            case "pokeRegions:SalamenceR":
                return new Salamence();
            case "pokeRegions:AronEnemy":
                return new Aron();
            case "pokeRegions:BreloomEnemy":
                return new Breloom();
            case "pokeRegions:Deoxys":
                return new DeoxysD();
            case "pokeRegions:EspeonAnnie":
                return new EspeonGX();
            case "pokeRegions:FlygonEnemy":
                return new FlygonV();
            case "pokeRegions:GardevoirEnemy":
                return new Gardevoir();
            case "pokeRegions:MetagrossEnemy":
                return new MetagrossEX();
            case "pokeRegions:RegiceEnemy":
                return new Regice();
            case "pokeRegions:RegisteelEnemy":
                return new Registeel();
            case "pokeRegions:Regirock":
                return new Regirock();
            case "pokeRegions:SalamenceEnemy":
                return new Salamence();
            case "pokeRegions:SlakingEnemy":
                return new Slaking();
            case "pokeRegions:TropiusEnemy":
                return new Tropius();
            case "pokeRegions:DialgaEnemy":
                return new DialgaGX();
            case "pokeRegions:GiratinaEnemy":
                return new GiratinaGX();
            case "pokeRegions:PalkiaEnemy":
                return new PalkiaGX();
            default:
                return new LouseRed();
        }
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Pokeball();
    }
}

