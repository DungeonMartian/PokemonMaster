package pokemonmaster;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PotionHelper;
import com.megacrit.cardcrawl.potions.AttackPotion;
import pokemonmaster.Potions.*;
import pokemonmaster.cards.Base.ExtraStarters.*;
import pokemonmaster.cards.Base.RockyHelmet;
import pokemonmaster.cards.Base.VitalityBand;
import pokemonmaster.cards.Dark.*;
import pokemonmaster.cards.Dragon.*;
import pokemonmaster.cards.Fighting.*;
import pokemonmaster.cards.Fire.*;
import pokemonmaster.cards.Grass.*;
import pokemonmaster.cards.Lightning.*;
import pokemonmaster.cards.Metal.*;
import pokemonmaster.cards.Normal.*;
import pokemonmaster.cards.Psychic.*;
import pokemonmaster.cards.Water.*;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.relics.*;

import java.util.*;

import static pokemonmaster.PokemonMasterMod.*;


public class TypeRemoverClass {

    public static boolean DOTHIS = true;
    public static boolean TOADD = true;
    private static Integer randInt1 =0;
    private static Integer randInt2 =0;
    private static Integer randInt3 =0;
    private static AbstractCard TOADD1;
    private static AbstractCard TOADD2;
    private static Set<Integer> set;
    public TypeRemoverClass() {
        TOADD = true;
    }

    public static void removeCards() {
        CardCrawlGame.dungeon.initializeCardPools();
        if (DOTHIS) {
            if (!AbstractDungeon.player.hasRelic("PrismaticShard")) {
                TOADD = true;
                if (AbstractDungeon.player.chosenClass == PokemonMaster.Enums.POKE_MASTER) {
                Random randNum = new Random();
                randNum.setSeed(Settings.seed);
                set = new LinkedHashSet<Integer>();
                randInt1 = randNum.nextInt(10) + 1;
                randInt2 = randNum.nextInt(10) + 1;

                    if (!psychicButton.toggle.enabled){
                        set.add(1);
                    }
                    if (!metalButton.toggle.enabled){
                        set.add(2);
                    }
                    if (!fireButton.toggle.enabled){
                        set.add(3);
                    }
                    if (!fightingButton.toggle.enabled){
                        set.add(4);
                    }
                    if (!grassButton.toggle.enabled){
                        set.add(5);
                    }
                    if (!lightningButton.toggle.enabled){
                        set.add(6);
                    }
                    if (!darkButton.toggle.enabled){
                        set.add(7);
                    }
                    if (!waterButton.toggle.enabled){
                        set.add(8);
                    }
                    if (!dragonButton.toggle.enabled){
                        set.add(9);
                    }
                    if (!normalButton.toggle.enabled){
                        set.add(10);
                    }
                    boolean answer = set.stream().anyMatch(s -> set.contains(randInt1));
                    int T=0;
                    while (answer) {
                        randInt1 = randNum.nextInt(10) + 1;
                        answer = set.stream().anyMatch(s -> set.contains(randInt1));
                        T++;
                        if (T == 14){
                            randInt1 =15;
                            break;
                        }
                    }
                    T=0;
                    boolean answer2 = set.stream().anyMatch(s -> set.contains(randInt2));
                    while (randInt2.equals(randInt1) || answer2) {
                        randInt2 = randNum.nextInt(10) + 1;
                        answer2 = set.stream().anyMatch(s -> set.contains(randInt2));
                        T++;
                        if (T == 14){
                            randInt2 = 15;
                            break;
                        }
                    }


                    randInt3 = randNum.nextInt(10) + 1;
                    while (randInt3.equals(randInt1) || randInt3.equals(randInt2)) {
                        randInt3 = randNum.nextInt(10) + 1;
                    }






            //this could very easily be done much better, but I didn't want to
            //you can theoretically lose your starting bonus if you use it to remove your bonus cards, then save load
            //in the neow room

                if (randInt1 == 1){
                    TOADD1 = new Elgyem();
                }
                else if (randInt1 == 2){
                    TOADD1 = new Meltan();
                }
                else if (randInt1 == 3){
                    TOADD1 = new Litleo();
                }
                else if (randInt1 == 4){
                    TOADD1 = new Rockruff();
                }
                else if (randInt1 == 5){
                    TOADD1 = new Skiddo();
                }
                else if (randInt1 == 6){
                    TOADD1 = new Yamper();
                }
                else if (randInt1 == 7){
                    TOADD1 = new Zorua();
                }
                else if (randInt1 == 8){
                    TOADD1 = new Clamperl();
                }
                else if (randInt1 == 9){
                    TOADD1 = new Noibat();
                }
                else if (randInt1 == 10){
                    TOADD1 = new Bidoof();
                }else {
                    TOADD1 = new RockyHelmet();
                }

                if (randInt2 == 1){
                    TOADD2 = new Elgyem();
                }
                else if (randInt2 == 2){
                    TOADD2 = new Meltan();
                }
                else if (randInt2 == 3){
                    TOADD2 = new Litleo();
                }
                else if (randInt2 == 4){
                    TOADD2 = new Rockruff();
                }
                else if (randInt2 == 5){
                    TOADD2 = new Skiddo();
                }
                else if (randInt2 == 6){
                    TOADD2 = new Yamper();
                }
                else if (randInt2 == 7){
                    TOADD2 = new Zorua();
                }
                else if (randInt2 == 8){
                    TOADD2 = new Clamperl();
                }
                else if (randInt2 == 9){
                    TOADD2 = new Noibat();
                }
                else if (randInt2 == 10){
                    TOADD2 = new Bidoof();
                }
                else {
                    TOADD2 = new VitalityBand();
                }




                if (PokemonMasterMod.enableNormalsButton.toggle.enabled) {
                    if (AbstractDungeon.floorNum < 1) {
                        for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                            if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                TOADD = false;
                                break;
                            }
                        }
                        if (TOADD) {
                            AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                        }

                    }
                    if (AbstractDungeon.floorNum < 1) {
                        for (AbstractCard t : (AbstractDungeon.player).masterDeck.group) {
                            if (Objects.equals(t.cardID, TOADD2.cardID)) {
                                TOADD = false;
                                break;
                            }
                        }
                        if (TOADD) {
                            AbstractDungeon.player.masterDeck.addToTop(TOADD2);
                        }

                    }
                }
                // add all integers from 1 to 30 except for the two random ones to the set
                //had to make this arbitrarily large to future proof for more added buckets
                if (AbstractDungeon.player.hasRelic(PuzzleCube.ID)) {
                    for (int i = 1; i < 31; i++) {
                        if (i != randInt1 && i != randInt2 && i != randInt3) {
                            set.add(i);
                        }
                    }
                }
                if (!AbstractDungeon.player.hasRelic(PuzzleCube.ID)) {
                    for (int i = 1; i < 31; i++) {
                        if (i != randInt1 && i != randInt2) {
                            set.add(i);
                        }
                    }
                }

                if (!PokemonMasterMod.enableNormalsButton.toggle.enabled) {
                    AbstractDungeon.rareRelicPool.remove(PuzzleCube.ID);
                    set = new LinkedHashSet<Integer>();
                    if (!PokemonMasterMod.darkButton.toggle.enabled) {
                        set.add(7);

                    }
                    if (PokemonMasterMod.darkButton.toggle.enabled) {
                        TOADD1 = new Zorua();
                        if (AbstractDungeon.floorNum < 1) {
                            for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                                if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                    TOADD = false;
                                    break;
                                }
                            }
                            if (TOADD) {
                                AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                            }

                        }
                    }
                    if (!PokemonMasterMod.dragonButton.toggle.enabled) {
                        set.add(9);
                    }
                    if (PokemonMasterMod.dragonButton.toggle.enabled) {
                        TOADD1 = new Noibat();
                        if (AbstractDungeon.floorNum < 1) {
                            for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                                if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                    TOADD = false;
                                    break;
                                }
                            }
                            if (TOADD) {
                                AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                            }

                        }
                    }
                    if (!PokemonMasterMod.fightingButton.toggle.enabled) {
                        set.add(4);
                    }
                    if (PokemonMasterMod.fightingButton.toggle.enabled) {
                        TOADD1 = new Rockruff();
                        if (AbstractDungeon.floorNum < 1) {
                            for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                                if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                    TOADD = false;
                                    break;
                                }
                            }
                            if (TOADD) {
                                AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                            }
                        }
                    }
                    if (!PokemonMasterMod.fireButton.toggle.enabled) {
                        set.add(3);
                    }
                    if (PokemonMasterMod.fireButton.toggle.enabled) {
                        TOADD1 = new Litleo();
                        if (AbstractDungeon.floorNum < 1) {
                            for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                                if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                    TOADD = false;
                                    break;
                                }
                            }
                            if (TOADD) {
                                AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                            }

                        }
                    }
                    if (!PokemonMasterMod.grassButton.toggle.enabled) {
                        set.add(5);
                    }
                    if (PokemonMasterMod.grassButton.toggle.enabled) {
                        TOADD1 = new Skiddo();
                        if (AbstractDungeon.floorNum < 1) {
                            for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                                if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                    TOADD = false;
                                    break;
                                }
                            }
                            if (TOADD) {
                                AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                            }

                        }
                    }
                    if (!PokemonMasterMod.lightningButton.toggle.enabled) {
                        set.add(6);
                    }
                    if (PokemonMasterMod.lightningButton.toggle.enabled) {
                        TOADD1 = new Yamper();
                        if (AbstractDungeon.floorNum < 1) {
                            for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                                if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                    TOADD = false;
                                    break;
                                }
                            }
                            if (TOADD) {
                                AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                            }
                        }
                    }
                    if (!PokemonMasterMod.metalButton.toggle.enabled) {
                        set.add(2);
                    }
                    if (PokemonMasterMod.metalButton.toggle.enabled) {
                        TOADD1 = new Meltan();
                        if (AbstractDungeon.floorNum < 1) {
                            for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                                if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                    TOADD = false;
                                    break;
                                }
                            }
                            if (TOADD) {
                                AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                            }

                        }
                    }
                    if (!PokemonMasterMod.normalButton.toggle.enabled) {
                        set.add(10);
                    }
                    if (PokemonMasterMod.normalButton.toggle.enabled) {
                        TOADD1 = new Bidoof();
                        if (AbstractDungeon.floorNum < 1) {
                            for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                                if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                    TOADD = false;
                                    break;
                                }
                            }
                            if (TOADD) {
                                AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                            }
                        }
                    }
                    if (!psychicButton.toggle.enabled) {
                        set.add(1);
                    }
                    if (psychicButton.toggle.enabled) {
                        TOADD1 = new Elgyem();
                        if (AbstractDungeon.floorNum < 1) {
                            for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                                if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                    TOADD = false;
                                    break;
                                }
                            }
                            if (TOADD) {
                                AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                            }
                        }
                    }
                    if (!PokemonMasterMod.waterButton.toggle.enabled) {
                        set.add(8);
                    }
                    if (PokemonMasterMod.waterButton.toggle.enabled) {
                        TOADD1 = new Clamperl();
                        if (AbstractDungeon.floorNum < 1) {
                            for (AbstractCard c : (AbstractDungeon.player).masterDeck.group) {
                                if (Objects.equals(c.cardID, TOADD1.cardID)) {
                                    TOADD = false;
                                    break;
                                }
                            }
                            if (TOADD) {
                                AbstractDungeon.player.masterDeck.addToTop(TOADD1);
                            }
                        }
                    }


                }
                Set<Integer> set2= new HashSet<>();
                    set2.add(1);
                    set2.add(2);
                    set2.add(3);
                    set2.add(4);
                    set2.add(5);
                    set2.add(6);
                    set2.add(7);
                    set2.add(8);
                    set2.add(9);
                    set2.add(10);


                    boolean BANSWER = set.stream().anyMatch(s -> set.containsAll(set2));
                    if (BANSWER){PotionHelper.potions.remove(AttackPotion.POTION_ID);
                        System.out.println("removed the attack potion");
                    }


                ArrayList<String> DARKTYPE = new ArrayList<>();
                DARKTYPE.add(Absol.ID);
                DARKTYPE.add(AlolanMeowth.ID);
                DARKTYPE.add(BlackGlasses.ID);
                DARKTYPE.add(CrobatV.ID);
                DARKTYPE.add(DarkraiGX.ID);
                DARKTYPE.add(Ekans.ID);
                DARKTYPE.add(EternatusV.ID);
                DARKTYPE.add(GalarianMoltresGX.ID);
                DARKTYPE.add(GalarianMoltres.ID);
                DARKTYPE.add(Grimer.ID);
                DARKTYPE.add(Gulpin.ID);
                DARKTYPE.add(HisuianSamurottV.ID);
                DARKTYPE.add(HisuianSneaslerV.ID);
                DARKTYPE.add(HonchkrowV.ID);
                DARKTYPE.add(Inkay.ID);
                DARKTYPE.add(Koffing.ID);
                DARKTYPE.add(LiepardEX.ID);
                DARKTYPE.add(Murkrow.ID);
                DARKTYPE.add(Nickit.ID);
                DARKTYPE.add(Poochyena.ID);
                DARKTYPE.add(Purrloin.ID);
                DARKTYPE.add(Qwilfish.ID);
                DARKTYPE.add(RadiantHisuainSneasler.ID);
                DARKTYPE.add(Roxie.ID);
                DARKTYPE.add(Seviper.ID);
                DARKTYPE.add(Sneasel.ID);
                DARKTYPE.add(Spiritomb.ID);
                DARKTYPE.add(TyranitarV.ID);
                DARKTYPE.add(WheezingV.ID);
                DARKTYPE.add(Varoom.ID);
                DARKTYPE.add(Venipede.ID);
                DARKTYPE.add(Vullaby.ID);


                ArrayList<String> LightningTYPE = new ArrayList<>();
                LightningTYPE.add(AlolanGeodude.ID);
                LightningTYPE.add(Blitzle.ID);
                LightningTYPE.add(Dedenne.ID);
                LightningTYPE.add(DedenneGX.ID);
                LightningTYPE.add(Electrike.ID);
                LightningTYPE.add(ElectrodeV.ID);
                LightningTYPE.add(Electropower.ID);
                LightningTYPE.add(Emolga.ID);
                LightningTYPE.add(Grubbin.ID);
                LightningTYPE.add(HisuianElectrodeV.ID);
                LightningTYPE.add(IronHands.ID);
                LightningTYPE.add(Mareep.ID);
                LightningTYPE.add(Minun.ID);
                LightningTYPE.add(Morpeko.ID);
                LightningTYPE.add(OricorioLightning.ID);
                LightningTYPE.add(Pachirisu.ID);
                LightningTYPE.add(Pichu.ID);
                LightningTYPE.add(Plusle.ID);
                LightningTYPE.add(Regieleki.ID);
                LightningTYPE.add(Raikou.ID);
                LightningTYPE.add(RaikouV.ID);
                LightningTYPE.add(Shinx.ID);
                LightningTYPE.add(Spark.ID);
                LightningTYPE.add(StormyMountain.ID);
                LightningTYPE.add(TapuKokoGX.ID);
                LightningTYPE.add(ThundurusV.ID);
                LightningTYPE.add(ToxtricityV.ID);
                LightningTYPE.add(Tynamo.ID);
                LightningTYPE.add(Voltorb.ID);
                LightningTYPE.add(Xurkitree.ID);
                LightningTYPE.add(Zapdos.ID);


                ArrayList<String> FIGHTINGTYPE = new ArrayList<>();
                FIGHTINGTYPE.add(Bunnelby.ID);
                FIGHTINGTYPE.add(Baltoy.ID);
                FIGHTINGTYPE.add(BodybuildingDumbbells.ID);
                FIGHTINGTYPE.add(Carbink.ID);
                FIGHTINGTYPE.add(CoalossalV.ID);
                FIGHTINGTYPE.add(Diglett.ID);
                FIGHTINGTYPE.add(Falinks.ID);
                FIGHTINGTYPE.add(FalinksV.ID);
                FIGHTINGTYPE.add(FightingStadium.ID);
                FIGHTINGTYPE.add(FocusSash.ID);
                FIGHTINGTYPE.add(GalarianFarfetchd.ID);
                FIGHTINGTYPE.add(Gligar.ID);
                FIGHTINGTYPE.add(HisuianArcanineV.ID);
                FIGHTINGTYPE.add(Kleavor.ID);
                FIGHTINGTYPE.add(Koraidonex.ID);
                FIGHTINGTYPE.add(MachoBrace.ID);
                FIGHTINGTYPE.add(Makuhita.ID);
                FIGHTINGTYPE.add(Mankey.ID);
                FIGHTINGTYPE.add(Onix.ID);
                FIGHTINGTYPE.add(Passimian.ID);
                FIGHTINGTYPE.add(Regirock.ID);
                FIGHTINGTYPE.add(Riolu.ID);
                FIGHTINGTYPE.add(Silicobra.ID);
                FIGHTINGTYPE.add(Stakataka.ID);
                FIGHTINGTYPE.add(StoneEnergy.ID);
                FIGHTINGTYPE.add(StrongEnergy.ID);
                FIGHTINGTYPE.add(Sudowoodo.ID);
                FIGHTINGTYPE.add(Terrakion.ID);
                FIGHTINGTYPE.add(Throh.ID);
                FIGHTINGTYPE.add(UrsalunaV.ID);
                FIGHTINGTYPE.add(ZamazentaV.ID);


                ArrayList<String> FIRETYPE = new ArrayList<>();
                FIRETYPE.add(CentiskorchV.ID);
                FIRETYPE.add(Charcoal.ID);
                FIRETYPE.add(CharizardV.ID);
                FIRETYPE.add(BurningScarf.ID);
                FIRETYPE.add(Darumaka.ID);
                FIRETYPE.add(DelphoxV.ID);
                FIRETYPE.add(InciniroarV.ID);
                FIRETYPE.add(InfernapeV.ID);
                FIRETYPE.add(EnteiV.ID);
                FIRETYPE.add(Fennekin.ID);
                FIRETYPE.add(FireCrystal.ID);
                FIRETYPE.add(Fletchling.ID);
                FIRETYPE.add(HeatEnergy.ID);
                FIRETYPE.add(Heatmor.ID);
                FIRETYPE.add(Hooh.ID);
                FIRETYPE.add(Kiawe.ID);
                FIRETYPE.add(Magmar.ID);
                FIRETYPE.add(MagmaBasin.ID);
                FIRETYPE.add(Numel.ID);
                FIRETYPE.add(OricorioFire.ID);
                FIRETYPE.add(Pansear.ID);
                FIRETYPE.add(Ponyta.ID);
                FIRETYPE.add(Slugma.ID);
                FIRETYPE.add(Reshiram.ID);
                FIRETYPE.add(Torchic.ID);
                FIRETYPE.add(Victini.ID);
                FIRETYPE.add(VictiniV.ID);
                FIRETYPE.add(Volcanion.ID);
                FIRETYPE.add(VolcaronaV.ID);
                FIRETYPE.add(Vulpix.ID);
                FIRETYPE.add(Welder.ID);


                ArrayList<String> GRASSTYPE = new ArrayList<>();
                GRASSTYPE.add(AromaticEnergy.ID);
                GRASSTYPE.add(Buzzwole.ID);
                GRASSTYPE.add(Cacnea.ID);
                GRASSTYPE.add(Calyrex.ID);
                GRASSTYPE.add(Capaskid.ID);
                GRASSTYPE.add(Celebi.ID);
                GRASSTYPE.add(ChesnaughtV.ID);
                GRASSTYPE.add(Durant.ID);
                GRASSTYPE.add(Dwebble.ID);
                GRASSTYPE.add(Exeggcute.ID);
                GRASSTYPE.add(GardeniasVigor.ID);
                GRASSTYPE.add(Heracross.ID);
                GRASSTYPE.add(HisuianLilligantV.ID);
                GRASSTYPE.add(Maractus.ID);
                GRASSTYPE.add(Morelull.ID);
                GRASSTYPE.add(NetBall.ID);
                GRASSTYPE.add(Nincada.ID);
                GRASSTYPE.add(Oddish.ID);
                GRASSTYPE.add(Paras.ID);
                GRASSTYPE.add(Phantump.ID);
                GRASSTYPE.add(Pinsir.ID);
                GRASSTYPE.add(Pheromosa.ID);
                GRASSTYPE.add(Revitalizer.ID);
                GRASSTYPE.add(Scyther.ID);
                GRASSTYPE.add(Shroomish.ID);
                GRASSTYPE.add(Shuckle.ID);
                GRASSTYPE.add(Sunkern.ID);
                GRASSTYPE.add(Oddish.ID);
                GRASSTYPE.add(Tangela.ID);
                GRASSTYPE.add(Tropius.ID);
                GRASSTYPE.add(VenusaurEX.ID);
                GRASSTYPE.add(VileplumeGX.ID);


                ArrayList<String> STEELTYPE = new ArrayList<>();
                STEELTYPE.add(AirBalloon.ID);
                STEELTYPE.add(AlolanDiglet.ID);
                STEELTYPE.add(Aron.ID);
                STEELTYPE.add(Bronzor.ID);
                STEELTYPE.add(Celesteela.ID);
                STEELTYPE.add(CoatingEnergy.ID);
                STEELTYPE.add(CopperajahV.ID);
                STEELTYPE.add(CrystalCave.ID);
                STEELTYPE.add(Drilbur.ID);
                STEELTYPE.add(Duraludon.ID);
                STEELTYPE.add(Ferroseed.ID);
                STEELTYPE.add(GalarianPerrserkerV.ID);
                STEELTYPE.add(GalarianStunfiskV.ID);
                STEELTYPE.add(GenesectV.ID);
                STEELTYPE.add(Gimmighoul.ID);
                STEELTYPE.add(Heatran.ID);
                STEELTYPE.add(Honedge.ID);
                STEELTYPE.add(KartanaGX.ID);
                STEELTYPE.add(Klefki.ID);
                STEELTYPE.add(Magnemite.ID);
                STEELTYPE.add(MetagrossEX.ID);
                STEELTYPE.add(MetalCoreBarrier.ID);
                STEELTYPE.add(MtCoronet.ID);
                STEELTYPE.add(Nosepass.ID);
                STEELTYPE.add(Orthworm.ID);
                STEELTYPE.add(RadiantSteelix.ID);
                STEELTYPE.add(Registeel.ID);
                STEELTYPE.add(Scizor.ID);
                STEELTYPE.add(ShieldEnergy.ID);
                STEELTYPE.add(Skarmory.ID);
                STEELTYPE.add(Zamazenta.ID);


                ArrayList<String> PSYCHICTYPE = new ArrayList<>();
                PSYCHICTYPE.add(Blacephalon.ID);
                PSYCHICTYPE.add(Chimecho.ID);
                PSYCHICTYPE.add(DeoxysD.ID);
                PSYCHICTYPE.add(DeoxysA.ID);
                PSYCHICTYPE.add(DeoxysS.ID);
                PSYCHICTYPE.add(Diancie.ID);
                PSYCHICTYPE.add(GalarianArticuno.ID);
                PSYCHICTYPE.add(Gastly.ID);
                PSYCHICTYPE.add(Giratina.ID);
                PSYCHICTYPE.add(HisuianTyphlosionV.ID);
                PSYCHICTYPE.add(HorrorEnergy.ID);
                PSYCHICTYPE.add(LostCity.ID);
                PSYCHICTYPE.add(Meditite.ID);
                PSYCHICTYPE.add(MewEX.ID);
                PSYCHICTYPE.add(MirageGate.ID);
                PSYCHICTYPE.add(Munna.ID);
                PSYCHICTYPE.add(Natu.ID);
                PSYCHICTYPE.add(Nihilego.ID);
                PSYCHICTYPE.add(OldCemetary.ID);
                PSYCHICTYPE.add(ParfumPalace.ID);
                PSYCHICTYPE.add(Ralts.ID);
                PSYCHICTYPE.add(RotomV.ID);
                PSYCHICTYPE.add(Sableye.ID);
                PSYCHICTYPE.add(Salandit.ID);
                PSYCHICTYPE.add(Skrelp.ID);
                PSYCHICTYPE.add(Shuppet.ID);
                PSYCHICTYPE.add(Sigilyph.ID);
                PSYCHICTYPE.add(TapuLele.ID);
                PSYCHICTYPE.add(Trubbish.ID);
                PSYCHICTYPE.add(Zubat.ID);
                PSYCHICTYPE.add(Unown.ID);


                ArrayList<String> WATERTYPE = new ArrayList<>();
                WATERTYPE.add(AquaPatch.ID);
                WATERTYPE.add(Articuno.ID);
                WATERTYPE.add(Cetoddle.ID);
                WATERTYPE.add(Chewtle.ID);
                WATERTYPE.add(Chinchou.ID);
                WATERTYPE.add(Corphish.ID);
                WATERTYPE.add(Cramorant.ID);
                WATERTYPE.add(Cryogonal.ID);
                WATERTYPE.add(Cubchoo.ID);
                WATERTYPE.add(Froakie.ID);
                WATERTYPE.add(GoodRod.ID);
                WATERTYPE.add(HisuianBasculin.ID);
                WATERTYPE.add(Keldeo.ID);
                WATERTYPE.add(Lana.ID);
                WATERTYPE.add(LaprasV.ID);
                WATERTYPE.add(Mareanie.ID);
                WATERTYPE.add(OldRod.ID);
                WATERTYPE.add(Piplup.ID);
                WATERTYPE.add(Tatsugiri.ID);
                WATERTYPE.add(Regice.ID);
                WATERTYPE.add(Slowpoke.ID);
                WATERTYPE.add(SharpedoEX.ID);
                WATERTYPE.add(ShiningMagikarp.ID);
                WATERTYPE.add(Shellos.ID);
                WATERTYPE.add(Snom.ID);
                WATERTYPE.add(Snover.ID);
                WATERTYPE.add(SuperRod.ID);
                WATERTYPE.add(SuicuneV.ID);
                WATERTYPE.add(Tympole.ID);
                WATERTYPE.add(Wailmer.ID);
                WATERTYPE.add(Wooper.ID);


                ArrayList<String> DRAGONTYPE = new ArrayList<>();
                DRAGONTYPE.add(AltariaV.ID);
                DRAGONTYPE.add(Applin.ID);
                DRAGONTYPE.add(Axew.ID);
                DRAGONTYPE.add(Bagon.ID);
                DRAGONTYPE.add(BlackKyuremEX.ID);
                DRAGONTYPE.add(Cyclizar.ID);
                DRAGONTYPE.add(DialgaGX.ID);
                DRAGONTYPE.add(DoubleDragonEnergy.ID);
                DRAGONTYPE.add(DragoniteV.ID);
                DRAGONTYPE.add(Drampa.ID);
                DRAGONTYPE.add(Druddigon.ID);
                DRAGONTYPE.add(DuraludonV.ID);
                DRAGONTYPE.add(Eternatus.ID);
                DRAGONTYPE.add(FlygonV.ID);
                DRAGONTYPE.add(Gible.ID);
                DRAGONTYPE.add(GiratinaGX.ID);
                DRAGONTYPE.add(Goomy.ID);
                DRAGONTYPE.add(Jangmoo.ID);
                DRAGONTYPE.add(Kyurem.ID);
                DRAGONTYPE.add(Latias.ID);
                DRAGONTYPE.add(Latios.ID);
                DRAGONTYPE.add(NsResolve.ID);
                DRAGONTYPE.add(PalkiaGX.ID);
                DRAGONTYPE.add(Regidrago.ID);
                DRAGONTYPE.add(Rayquaza.ID);
                DRAGONTYPE.add(RoaringMoon.ID);
                DRAGONTYPE.add(SalamenceV.ID);
                DRAGONTYPE.add(TatsugiriDragon.ID);
                DRAGONTYPE.add(Turtonator.ID);
                DRAGONTYPE.add(UltraNecrozmaV.ID);
                DRAGONTYPE.add(WhiteKyuremGX.ID);


                ArrayList<String> NORMALTYPE = new ArrayList<>();
                NORMALTYPE.add(Audino.ID);
                NORMALTYPE.add(BlisseyV.ID);
                NORMALTYPE.add(Bouffalant.ID);
                NORMALTYPE.add(Cheren.ID);
                NORMALTYPE.add(Clefairy.ID);
                NORMALTYPE.add(Dratini.ID);
                NORMALTYPE.add(DubwoolV.ID);
                NORMALTYPE.add(Dunsparce.ID);
                NORMALTYPE.add(Furfrou.ID);
                NORMALTYPE.add(Komala.ID);
                NORMALTYPE.add(Leftovers.ID);
                NORMALTYPE.add(LugiaGX.ID);
                NORMALTYPE.add(Meloetta.ID);
                NORMALTYPE.add(Miltank.ID);
                NORMALTYPE.add(OranguruV.ID);
                NORMALTYPE.add(Porygon.ID);
                NORMALTYPE.add(PorygonEX.ID);
                NORMALTYPE.add(Regigigas.ID);
                NORMALTYPE.add(Sentret.ID);
                NORMALTYPE.add(Shroodle.ID);
                NORMALTYPE.add(Slakoth.ID);
                NORMALTYPE.add(Smeargle.ID);
                NORMALTYPE.add(Snorlax.ID);
                NORMALTYPE.add(Taillow.ID);
                NORMALTYPE.add(Tauros.ID);
                NORMALTYPE.add(Winona.ID);
                NORMALTYPE.add(Wingull.ID);
                NORMALTYPE.add(Whismur.ID);
                NORMALTYPE.add(WyrdeerV.ID);
                NORMALTYPE.add(Yungoos.ID);
                NORMALTYPE.add(Zigzagoon.ID);





                for (int s : set) {
                    if (s == 1) {
                        for (String j : PSYCHICTYPE) {
                            AbstractDungeon.commonCardPool.removeCard(j);
                            AbstractDungeon.uncommonCardPool.removeCard(j);
                            AbstractDungeon.rareCardPool.removeCard(j);
                            AbstractDungeon.srcCommonCardPool.removeCard(j);
                            AbstractDungeon.srcUncommonCardPool.removeCard(j);
                            AbstractDungeon.srcRareCardPool.removeCard(j);
                            PotionHelper.potions.remove(MindStone.POTION_ID);
                            AbstractDungeon.uncommonRelicPool.remove(TwistedSpoon.ID);
                            AbstractDungeon.rareRelicPool.remove(TwistedSpoon.ID);
                            AbstractDungeon.shopRelicPool.remove(TwistedSpoon.ID);
                        }
                    }
                }
                for (int s : set) {
                    if (s == 2) {
                        for (String e : STEELTYPE) {
                            AbstractDungeon.commonCardPool.removeCard(e);
                            AbstractDungeon.uncommonCardPool.removeCard(e);
                            AbstractDungeon.rareCardPool.removeCard(e);
                            AbstractDungeon.srcCommonCardPool.removeCard(e);
                            AbstractDungeon.srcUncommonCardPool.removeCard(e);
                            AbstractDungeon.srcRareCardPool.removeCard(e);
                            PotionHelper.potions.remove(e);
                        }
                    }
                }
                for (int s : set) {
                    if (s == 3) {
                        for (String F : FIRETYPE) {
                            AbstractDungeon.commonCardPool.removeCard(F);
                            AbstractDungeon.uncommonCardPool.removeCard(F);
                            AbstractDungeon.rareCardPool.removeCard(F);
                            AbstractDungeon.srcCommonCardPool.removeCard(F);
                            AbstractDungeon.srcUncommonCardPool.removeCard(F);
                            AbstractDungeon.srcRareCardPool.removeCard(F);
                            AbstractDungeon.rareRelicPool.remove(HotPotato.ID);
                            AbstractDungeon.shopRelicPool.remove(HotPotato.ID);
                            PotionHelper.potions.remove(FireStone.POTION_ID);


                        }

                    }
                }
                for (int s : set) {
                    if (s == 4) {
                        for (String G : FIGHTINGTYPE) {
                            AbstractDungeon.commonCardPool.removeCard(G);
                            AbstractDungeon.uncommonCardPool.removeCard(G);
                            AbstractDungeon.rareCardPool.removeCard(G);
                            AbstractDungeon.srcCommonCardPool.removeCard(G);
                            AbstractDungeon.srcUncommonCardPool.removeCard(G);
                            AbstractDungeon.srcRareCardPool.removeCard(G);
                            AbstractDungeon.commonRelicPool.remove(ChoiceBand.ID);
                            AbstractDungeon.shopRelicPool.remove(ChoiceBand.ID);
                            //PotionHelper.potions.remove(G);


                        }

                    }
                }
                for (int s : set) {
                    if (s == 5) {
                        for (String H : GRASSTYPE) {
                            AbstractDungeon.commonCardPool.removeCard(H);
                            AbstractDungeon.uncommonCardPool.removeCard(H);
                            AbstractDungeon.rareCardPool.removeCard(H);
                            AbstractDungeon.srcCommonCardPool.removeCard(H);
                            AbstractDungeon.srcUncommonCardPool.removeCard(H);
                            AbstractDungeon.srcRareCardPool.removeCard(H);
                            PotionHelper.potions.remove(LeafStone.POTION_ID);
                            AbstractDungeon.rareRelicPool.remove(MiracleSeed.ID);
                            AbstractDungeon.shopRelicPool.remove(MiracleSeed.ID);

                        }
                    }
                }
                for (int s : set) {
                    if (s == 6) {
                        for (String L : LightningTYPE) {
                            AbstractDungeon.commonCardPool.removeCard(L);
                            AbstractDungeon.uncommonCardPool.removeCard(L);
                            AbstractDungeon.rareCardPool.removeCard(L);
                            AbstractDungeon.srcCommonCardPool.removeCard(L);
                            AbstractDungeon.srcUncommonCardPool.removeCard(L);
                            AbstractDungeon.srcRareCardPool.removeCard(L);
                            PotionHelper.potions.remove(ThunderStone.POTION_ID);


                        }
                    }
                }
                for (int s : set) {
                    if (s == 7) {
                        for (String D : DARKTYPE) {
                            AbstractDungeon.commonCardPool.removeCard(D);
                            AbstractDungeon.uncommonCardPool.removeCard(D);
                            AbstractDungeon.rareCardPool.removeCard(D);
                            AbstractDungeon.srcCommonCardPool.removeCard(D);
                            AbstractDungeon.srcUncommonCardPool.removeCard(D);
                            AbstractDungeon.srcRareCardPool.removeCard(D);
                            AbstractDungeon.uncommonRelicPool.remove(QuickClaw.ID);
                            AbstractDungeon.shopRelicPool.remove(QuickClaw.ID);
                            PotionHelper.potions.remove(BleakStone.POTION_ID);


                        }


                    }
                }
                for (int s : set) {
                    if (s == 8) {
                        for (String W : WATERTYPE) {
                            AbstractDungeon.commonCardPool.removeCard(W);
                            AbstractDungeon.uncommonCardPool.removeCard(W);
                            AbstractDungeon.rareCardPool.removeCard(W);
                            AbstractDungeon.srcCommonCardPool.removeCard(W);
                            AbstractDungeon.srcUncommonCardPool.removeCard(W);
                            AbstractDungeon.srcRareCardPool.removeCard(W);
                            AbstractDungeon.uncommonRelicPool.remove(SharkBait.ID);
                            AbstractDungeon.shopRelicPool.remove(SharkBait.ID);
                            PotionHelper.potions.remove(WaterStone.POTION_ID);


                        }

                    }
                }

                for (int s : set) {
                    if (s == 9) {
                        for (String Y : DRAGONTYPE) {
                            AbstractDungeon.commonCardPool.removeCard(Y);
                            AbstractDungeon.uncommonCardPool.removeCard(Y);
                            AbstractDungeon.rareCardPool.removeCard(Y);
                            AbstractDungeon.srcCommonCardPool.removeCard(Y);
                            AbstractDungeon.srcUncommonCardPool.removeCard(Y);
                            AbstractDungeon.srcRareCardPool.removeCard(Y);



                        }

                    }
                }
                for (int s : set) {
                    if (s == 10) {
                        for (String N : NORMALTYPE) {
                            AbstractDungeon.commonCardPool.removeCard(N);
                            AbstractDungeon.uncommonCardPool.removeCard(N);
                            AbstractDungeon.rareCardPool.removeCard(N);
                            AbstractDungeon.srcCommonCardPool.removeCard(N);
                            AbstractDungeon.srcUncommonCardPool.removeCard(N);
                            AbstractDungeon.srcRareCardPool.removeCard(N);
                            AbstractDungeon.uncommonRelicPool.remove(MooMooMilk.ID);
                            AbstractDungeon.rareRelicPool.remove(MooMooMilk.ID);
                            AbstractDungeon.shopRelicPool.remove(MooMooMilk.ID);


                        }

                    }
                }
            }
            DOTHIS = false;
        }
}
    }
}
