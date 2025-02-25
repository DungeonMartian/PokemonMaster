package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Dragalge extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Dragalge",
            2,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 2;
    private static final int MAGIC = 4;
    private static final int UPG_MAGIC = 3;


    public Dragalge() {
        super(cardInfo,CustomTags.PSYCHIC);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);



        this.isMultiDamage = true;
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackPsychic.png","pokemonmaster/character/cardback/bg_attackPsychic_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
            for (int i =0; i <3; i++) {
                addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
            }
            if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
                for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
                    if (!monster.isDead && !monster.isDying) {
                        addToBot(new ApplyPowerAction(monster, p, new PoisonPower(monster, p, magicNumber), magicNumber));
                    }
                }
            }
            AbstractCard S = new Skrelp();
            if(this.upgraded){S.upgrade();}
            addToBot(new MakeTempCardInDiscardAction(S, 1));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Dragalge();
    }
}

