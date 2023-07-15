package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Gholdengo extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Gholdengo",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 18;
    private static final int UPG_DAMAGE = 8;



    public Gholdengo() {
        super(cardInfo);
        this.isMultiDamage = true;
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);
        this.exhaust = true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));
        for (AbstractMonster monster : (AbstractDungeon.getMonsters()).monsters) {
        if (!monster.isDead && !monster.isDying) {
            addToBot(new ApplyPowerAction(monster, p, new WeakPower(monster, 2, false), 2));
        }
    }
        int roll = AbstractDungeon.relicRng.random(0, 99);
        if (roll < 50){
            AbstractRelic r = AbstractDungeon.returnRandomScreenlessRelic(AbstractRelic.RelicTier.COMMON);
            AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F, r);}
        if (roll > 82){
            AbstractRelic s = AbstractDungeon.returnRandomScreenlessRelic(AbstractRelic.RelicTier.RARE);
            AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F, s);}
        if (roll <82 && roll >50) {
            AbstractRelic t = AbstractDungeon.returnRandomScreenlessRelic(AbstractRelic.RelicTier.UNCOMMON);
        AbstractDungeon.getCurrRoom().spawnRelicAndObtain(Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F, t);}

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Gholdengo();
    }
}

