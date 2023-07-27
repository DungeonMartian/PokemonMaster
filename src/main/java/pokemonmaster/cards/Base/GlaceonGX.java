package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.BlizzardEffect;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GlaceonGX extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GlaceonGX",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 2;


    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 1;



    public GlaceonGX() {
        super(cardInfo);
        this.isMultiDamage = true;
        tags.add(CustomTags.WATER);
        tags.add(CustomTags.POKEMON);
        setDamage(DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++) {
            addToBot(new VFXAction(new BlizzardEffect(this.damage,
                    AbstractDungeon.getMonsters().shouldFlipVfx()), 0.15F));
            addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));

        }
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
            }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GlaceonGX();
    }
}

