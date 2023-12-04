package pokemonmaster.cards.Lightning;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Ampharos extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Ampharos",
            2,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 6;



    public Ampharos() {
        super(cardInfo,CustomTags.LIGHTNING);
        setDamage(DAMAGE, UPG_DAMAGE);

        this.exhaust=true;

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackLightning.png","pokemonmaster/character/cardback/bg_attackLightning_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i<=1; i++){
            AbstractMonster randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
            if (randomMonster != null) {
                addToBot(new StunMonsterAction(randomMonster, p));
                addToBot(new DamageAction(randomMonster, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.LIGHTNING));
            }
        }
    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new Ampharos();
    }
}

