package pokemonmaster.cards.Base.ExtraStarters;

import com.evacipated.cardcrawl.mod.stslib.damagemods.DamageModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.Actions.PiercingDamage;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Elgyem extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Elgyem",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;



    public Elgyem() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.purgeOnUse = true;
        this.evolve=new Beheeyem();
        this.cardsToPreview=this.evolve;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackPsychic.png","pokemonmaster/character/cardback/bg_attackPsychic_p.png");
        DamageModifierManager.addModifier(this, new PiercingDamage());
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new EvolveActionCombat(this, AbstractDungeon.player.drawPile));
    }
    public void upgrade() {
        this.cardsToPreview.upgrade();
        super.upgrade();
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Elgyem();
    }
}

