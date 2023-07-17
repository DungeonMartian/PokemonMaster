package pokemonmaster.cards.StarterRelic.Act3;

import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class WrithingMass extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "WrithingMass",
            2,
            CardType.SKILL,
            CardTarget.ALL,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC= 1;
    private static final int DAMAGE = 32;
    private static final int UPG_DAMAGE = 6;
    private static final int BLOCK = 16;
    private static final int UPG_BLOCK= 2;

    public WrithingMass() {
        super(cardInfo);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(MAGIC,UPG_MAGIC);
        setDamage(DAMAGE,UPG_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int RANDOM_INT = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
        if (RANDOM_INT ==1) {
            addToBot(new GainBlockAction(p, p, block));
        }
        if (RANDOM_INT ==2) {
            this.damageTypeForTurn= DamageInfo.DamageType.THORNS;
            addToBot(new AttackDamageRandomEnemyAction(this));

        }
        if (RANDOM_INT ==3) {
            AbstractMonster monster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
            addToBot(new ApplyPowerAction(monster, p, new WeakPower(monster, magicNumber, false)));
            addToBot(new ApplyPowerAction(monster, p, new VulnerablePower(monster, magicNumber, false)));
            }

        if (RANDOM_INT ==4) {
            AbstractMonster monster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
            addToBot(new StunMonsterAction(monster, p));

        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new WrithingMass();
    }
}

