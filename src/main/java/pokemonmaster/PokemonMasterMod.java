package pokemonmaster;

import basemod.*;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.evacipated.cardcrawl.modthespire.Loader;
import com.evacipated.cardcrawl.modthespire.ModInfo;
import com.evacipated.cardcrawl.modthespire.Patcher;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.status.Slimed;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.scannotation.AnnotationDB;
import pokemonmaster.Potions.*;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.Metal.Magnet;
import pokemonmaster.cards.Water.FishingCards.Cursola;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.relics.BaseRelic;
import pokemonmaster.util.GeneralUtils;
import pokemonmaster.util.KeywordInfo;
import pokemonmaster.util.TextureLoader;

import java.nio.charset.StandardCharsets;
import java.util.*;

import static basemod.BaseMod.addRelic;

@SpireInitializer
public class PokemonMasterMod implements
        EditStringsSubscriber,
        EditKeywordsSubscriber,
        EditCardsSubscriber,
        EditRelicsSubscriber,
        EditCharactersSubscriber,
        StartGameSubscriber,
        StartActSubscriber,
        PostDungeonInitializeSubscriber,
        PostInitializeSubscriber {

    public static ModInfo info;
    public static String modID;
    public  Set<Integer> set1;
    static {
        loadModInfo();
    }
    public static boolean selectedCards = false;
    public static final Logger logger = LogManager.getLogger(modID); //Used to output to the console.
    private static final String resourcesFolder = "pokemonmaster";
    private static Properties PokemonMasterModSettings = new Properties();

    private static final String ENABLE_PLACEHOLDER_SETTINGS = "enablePlaceholder";

    private static boolean RandomizeTypes = true;
    private static boolean DarkType = true;
    private static boolean DragonType = true;
    private static boolean FightingType = true;
    private static boolean FireType = true;
    private static boolean GrassType = true;
    private static boolean LightningType = true;
    private static boolean MetalType = true;
    private static boolean NormalType = true;
    private static boolean PsychicType = true;
    private static boolean WaterType = true;
    public static ModLabeledToggleButton enableNormalsButton;




    //This is used to prefix the IDs of various objects like cards and relics,
    //to avoid conflicts between different mods using the same name for things.
    public static String makeID(String id) {
        return modID + ":" + id;
    }

    //This will be called by ModTheSpire because of the @SpireInitializer annotation at the top of the class.

    private static final String BG_ATTACK = characterPath("cardback/bg_attack.png");
    private static final String BG_ATTACK_P = characterPath("cardback/bg_attack_p.png");
    private static final String BG_SKILL = characterPath("cardback/bg_skill.png");
    private static final String BG_SKILL_P = characterPath("cardback/bg_skill_p.png");
    private static final String BG_POWER = characterPath("cardback/bg_power.png");
    private static final String BG_POWER_P = characterPath("cardback/bg_power_p.png");
    private static final String ENERGY_ORB = characterPath("cardback/energy_orb.png");
    private static final String ENERGY_ORB_P = characterPath("cardback/energy_orb_p.png");
    private static final String SMALL_ORB = characterPath("cardback/small_orb.png");
    private static final String CHAR_SELECT_BUTTON = characterPath("select/button.png");
    private static final String CHAR_SELECT_PORTRAIT = characterPath("select/portrait.png");
    private static final Color POKEMONMASTER_AZURE_COLOR = new Color(240f / 255f, 254f / 255f, 254f / 255f, 1f);

    public static Settings.GameLanguage[] SupportedLanguages = new Settings.GameLanguage[] { Settings.GameLanguage.ENG, Settings.GameLanguage.ZHS };
    public static void initialize() {
        new PokemonMasterMod();

        BaseMod.addColor(PokemonMaster.Enums.CARD_COLOR, POKEMONMASTER_AZURE_COLOR,
                BG_ATTACK, BG_SKILL, BG_POWER, ENERGY_ORB,
                BG_ATTACK_P, BG_SKILL_P, BG_POWER_P, ENERGY_ORB_P,
                SMALL_ORB);


    }

    public PokemonMasterMod() {
        BaseMod.subscribe(this);

        //This will make BaseMod trigger all the subscribers at their appropriate times.
        PokemonMasterModSettings.setProperty("RandomizeTypes", "TRUE");
        PokemonMasterModSettings.setProperty("DarkType", "TRUE");
        PokemonMasterModSettings.setProperty("DragonType", "TRUE");
        PokemonMasterModSettings.setProperty("FightingType", "TRUE");
        PokemonMasterModSettings.setProperty("FireType", "TRUE");
        PokemonMasterModSettings.setProperty("GrassType", "TRUE");
        PokemonMasterModSettings.setProperty("LightningType", "TRUE");
        PokemonMasterModSettings.setProperty("MetalType", "TRUE");
        PokemonMasterModSettings.setProperty("NormalType", "TRUE");
        PokemonMasterModSettings.setProperty("PsychicType", "TRUE");
        PokemonMasterModSettings.setProperty("WaterType", "TRUE");

        try {
            SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
            config.load();
            RandomizeTypes = Boolean.valueOf(config.getBool("RandomizeTypes"));
            DarkType = Boolean.valueOf(config.getBool("DarkType"));
            DragonType = Boolean.valueOf(config.getBool("DragonType"));
            FightingType = Boolean.valueOf(config.getBool("FightingType"));
            FireType = Boolean.valueOf(config.getBool("FireType"));
            GrassType = Boolean.valueOf(config.getBool("GrassType"));
            LightningType = Boolean.valueOf(config.getBool("LightningType"));
            MetalType = Boolean.valueOf(config.getBool("MetalType"));
            NormalType = Boolean.valueOf(config.getBool("NormalType"));
            PsychicType = Boolean.valueOf(config.getBool("PsychicType"));
            WaterType = Boolean.valueOf(config.getBool("WaterType"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Done adding mod settings");
    }

    public static String getModID() {
        return modID;
    }

    public static Set<Integer> set1() {
        return null;
    }


    @Override
    public void receivePostInitialize() {
        //This loads the image used as an icon in the in-game mods menu.
        //Texture badgeTexture = TextureLoader.getTexture(resourcePath("badge.png"));
        //Set up the mod information displayed in the in-game mods menu.
        //The information used is taken from your pom.xml file.
        //BaseMod.registerModBadge(badgeTexture, info.Name, GeneralUtils.arrToString(info.Authors), info.Description, null);


        addPotions();
        createConfigMenu();


    }

    public void createConfigMenu() {
        logger.info("Loading badge image and mod options");
        Texture badgeTexture = TextureLoader.getTexture(characterPath("Pokeball.png"));
        ModPanel settingsPanel = new ModPanel();


        ModLabeledToggleButton enableNormalsButton = new ModLabeledToggleButton("Randomize your types at the start of the run (Overides other options).", 350.0F, 800.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            RandomizeTypes = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("RandomizeTypes", RandomizeTypes);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)enableNormalsButton);

        ModLabeledToggleButton darkButton = new ModLabeledToggleButton("Dark types will be available.", 350.0F, 750.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            DarkType = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("DarkType", DarkType);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)darkButton);

        ModLabeledToggleButton dragonButton = new ModLabeledToggleButton("Dragon types will be available.", 350.0F, 700.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            DragonType = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("DragonType", DragonType);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)dragonButton);

        ModLabeledToggleButton fightingButton = new ModLabeledToggleButton("Fighting types will be available.", 350.0F, 650.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            FightingType = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("FightingType", FightingType);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)fightingButton);

        ModLabeledToggleButton fireButton = new ModLabeledToggleButton("Fire types will be available.", 350.0F, 600.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            FireType = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("FireType", FireType);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)fireButton);

        ModLabeledToggleButton grassButton = new ModLabeledToggleButton("Grass types will be available.", 350.0F, 550.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            GrassType = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("GrassType", GrassType);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)grassButton);

        ModLabeledToggleButton lightningButton = new ModLabeledToggleButton("Lightning types will be available.", 350.0F, 500.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            LightningType = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("LightningType", LightningType);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)lightningButton);

        ModLabeledToggleButton metalButton = new ModLabeledToggleButton("Metal types will be available.", 350.0F, 450.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            MetalType = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("MetalType", MetalType);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)metalButton);

        ModLabeledToggleButton normalButton = new ModLabeledToggleButton("Normal types will be available.", 350.0F, 400.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            NormalType = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("NormalType", NormalType);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)normalButton);

        ModLabeledToggleButton psychicButton = new ModLabeledToggleButton("Psychic types will be available.", 350.0F, 350.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            PsychicType = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("PsychicType", PsychicType);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)psychicButton);

        ModLabeledToggleButton waterButton = new ModLabeledToggleButton("Water types will be available.", 350.0F, 300.0F, Settings.CREAM_COLOR, FontHelper.charDescFont, RandomizeTypes, settingsPanel,  label -> {}, button -> {
            WaterType = button.enabled;
            try {
                SpireConfig config = new SpireConfig(getModID(), getModID() + "Config", PokemonMasterModSettings);
                config.setBool("WaterType", WaterType);
                config.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        settingsPanel.addUIElement((IUIElement)waterButton);


        BaseMod.registerModBadge(badgeTexture, info.Name, GeneralUtils.arrToString((Object[])info.Authors), info.Description, settingsPanel);
        logger.info("Done loading badge Image and mod options");
    }

    /*----------Localization----------*/

    //This is used to load the appropriate localization files based on language.
    private static String getLangString() {
        return Settings.language.name().toLowerCase();
    }

    private static final String defaultLanguage = "eng";

    @Override
    public void receiveEditStrings() {
        /*
            First, load the default localization.
            Then, if the current language is different, attempt to load localization for that language.
            This results in the default localization being used for anything that might be missing.
            The same process is used to load keywords slightly below.
        */
        loadLocalization(defaultLanguage); //no except catching for default localization, you better have at least one that works.
        if (!defaultLanguage.equals(getLangString())) {
            try {
                loadLocalization(getLangString());
            } catch (GdxRuntimeException e) {
                e.printStackTrace();
            }
        }
    }


    private void loadLocalization(String lang) {
        //While this does load every type of localization, most of these files are just outlines so that you can see how they're formatted.
        //Feel free to comment out/delete any that you don't end up using.
        BaseMod.loadCustomStringsFile(CardStrings.class,
                localizationPath(lang, "CardStrings.json"));
        BaseMod.loadCustomStringsFile(CharacterStrings.class,
                localizationPath(lang, "CharacterStrings.json"));
        BaseMod.loadCustomStringsFile(EventStrings.class,
                localizationPath(lang, "EventStrings.json"));
        BaseMod.loadCustomStringsFile(OrbStrings.class,
                localizationPath(lang, "OrbStrings.json"));
        BaseMod.loadCustomStringsFile(PotionStrings.class,
                localizationPath(lang, "PotionStrings.json"));
        BaseMod.loadCustomStringsFile(PowerStrings.class,
                localizationPath(lang, "PowerStrings.json"));
        BaseMod.loadCustomStringsFile(RelicStrings.class,
                localizationPath(lang, "RelicStrings.json"));
        BaseMod.loadCustomStringsFile(UIStrings.class,
                localizationPath(lang, "UIStrings.json"));
    }

    @Override
    public void receiveEditKeywords() {
        Gson gson = new Gson();
        String json = Gdx.files.internal(localizationPath(defaultLanguage, "Keywords.json")).readString(String.valueOf(StandardCharsets.UTF_8));
        KeywordInfo[] keywords = gson.fromJson(json, KeywordInfo[].class);
        for (KeywordInfo keyword : keywords) {
            registerKeyword(keyword);
        }

        if (!defaultLanguage.equals(getLangString())) {
            try {
                json = Gdx.files.internal(localizationPath(getLangString(), "Keywords.json")).readString(String.valueOf(StandardCharsets.UTF_8));
                keywords = gson.fromJson(json, KeywordInfo[].class);
                for (KeywordInfo keyword : keywords) {
                    registerKeyword(keyword);
                }
            } catch (Exception e) {
                logger.warn(modID + " does not support " + getLangString() + " keywords.");
            }
        }
    }

    public static void addPotions() {
        BaseMod.addPotion(ParkBall.class, Color.GOLDENROD, Color.WHITE, null, ParkBall.POTION_ID, PokemonMaster.Enums.POKE_MASTER);
        BaseMod.addPotion(ThunderStone.class, Color.YELLOW, Color.GREEN, null, ThunderStone.POTION_ID, PokemonMaster.Enums.POKE_MASTER);
        BaseMod.addPotion(FireStone.class, Color.RED, Color.YELLOW, null, FireStone.POTION_ID, PokemonMaster.Enums.POKE_MASTER);
        BaseMod.addPotion(MindStone.class, Color.PURPLE, Color.PINK, null, MindStone.POTION_ID, PokemonMaster.Enums.POKE_MASTER);
        BaseMod.addPotion(BleakStone.class, Color.BLACK, Color.YELLOW, null, BleakStone.POTION_ID, PokemonMaster.Enums.POKE_MASTER);
        BaseMod.addPotion(WaterStone.class, Color.BLUE, Color.SLATE, null, WaterStone.POTION_ID, PokemonMaster.Enums.POKE_MASTER);
        BaseMod.addPotion(LeafStone.class, Color.GREEN, Color.BROWN, null, LeafStone.POTION_ID, PokemonMaster.Enums.POKE_MASTER);
        BaseMod.addPotion(ResistancePotion.class, Color.BLUE, Color.GRAY, null, ResistancePotion.POTION_ID);
        BaseMod.addPotion(BurnPotion.class, Color.RED, Color.SCARLET, null, BurnPotion.POTION_ID);
    }
    private void registerKeyword(KeywordInfo info) {
        BaseMod.addKeyword(modID.toLowerCase(), info.PROPER_NAME, info.NAMES, info.DESCRIPTION);
    }

    //These methods are used to generate the correct filepaths to various parts of the resources folder.
    public static String localizationPath(String lang, String file) {
        return resourcesFolder + "/localization/" + lang + "/" + file;
    }

    public static String resourcePath(String file) {
        return resourcesFolder + "/" + file;
    }

    public static String characterPath(String file) {
        return resourcesFolder + "/character/" + file;
    }

    public static String powerPath(String file) {
        return resourcesFolder + "/powers/" + file;
    }

    public static String relicPath(String file) {
        return resourcesFolder + "/relics/" + file;
    }


    //This determines the mod's ID based on information stored by ModTheSpire.
    private static void loadModInfo() {
        Optional<ModInfo> infos = Arrays.stream(Loader.MODINFOS).filter((modInfo) -> {
            AnnotationDB annotationDB = Patcher.annotationDBMap.get(modInfo.jarURL);
            if (annotationDB == null)
                return false;
            Set<String> initializers = annotationDB.getAnnotationIndex().getOrDefault(SpireInitializer.class.getName(), Collections.emptySet());
            return initializers.contains(PokemonMasterMod.class.getName());
        }).findFirst();
        if (infos.isPresent()) {
            info = infos.get();
            modID = info.ID;
        } else {
            throw new RuntimeException("Failed to determine mod info/ID based on initializer.");
        }
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new PokemonMaster(),
                CHAR_SELECT_BUTTON, CHAR_SELECT_PORTRAIT, PokemonMaster.Enums.POKE_MASTER);


    }


    @Override
    public void receiveEditCards() {
        new AutoAdd(modID) //Loads files from this mod
                .packageFilter(BaseCard.class) //In the same package as this class
                .setDefaultSeen(true) //And marks them as seen in the compendium
                .cards(); //Adds the cards


    }


    @Override
    public void receiveEditRelics() { //somewhere in the class
        new AutoAdd(modID) //Loads files from this mod
                .packageFilter(BaseRelic.class) //In the same package as this class
                .any(BaseRelic.class, (info, relic) -> { //Run this code for any classes that extend this class
                    if (relic.pool != null)
                        BaseMod.addRelicToCustomPool(relic, relic.pool); //Register a custom character specific relic
                    else
                        addRelic(relic, relic.relicType); //Register a shared or base game character specific relic

                    //If the class is annotated with @AutoAdd.Seen, it will be marked as seen, making it visible in the relic library.
                    //If you want all your relics to be visible by default, just remove this if statement.
                    if (info.seen)
                        UnlockTracker.markRelicAsSeen(relic.relicId);
                });
    }



    @Override
    public void receiveStartGame() {
        TypeRemoverClass.DOTHIS = true;
        TypeRemoverClass.removeCards();

    }

    @Override
    public void receiveStartAct() {
        TypeRemoverClass.DOTHIS=true;
        TypeRemoverClass.removeCards();
    }

    private static void TypeChoice() {
        logger.info("Total packs: ");
        CardGroup RUNTYPEs = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        RUNTYPEs.addToTop(new Cursola());
        RUNTYPEs.addToTop(new Slimed());
        RUNTYPEs.addToTop(new Magnet());



        AbstractDungeon.gridSelectScreen.open(RUNTYPEs, 3, true, "bree");
        selectedCards = true;
        CardCrawlGame.dungeon.initializeCardPools();
    }
    @Override
    public void receivePostDungeonInitialize() {
        TypeRemoverClass.DOTHIS=true;
        TypeRemoverClass.removeCards();

    }
}
