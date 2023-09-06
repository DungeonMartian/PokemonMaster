package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.BiteEffect;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Rayquaza extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Rayquaza",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 25;
    private static final int UPG_DAMAGE = 15;
    private static final int MAGIC = 1;


    private boolean ISELITE = false;
    public Rayquaza() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);
        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        ISELITE = false;

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDragon.png","pokemonmaster/character/cardback/bg_attackDragon_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new BiteEffect(m.hb.cX, m.hb.cY), 0.3F));

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        for (AbstractMonster j : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            if (j.type == AbstractMonster.EnemyType.BOSS || j.type == AbstractMonster.EnemyType.ELITE) {
                ISELITE = true;
                break;
            }
        }
        if (ISELITE) {
                addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

            }

        addToBot(new ApplyPowerAction(p, p, new Spark(p,-MAGIC)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Rayquaza();
    }
}

