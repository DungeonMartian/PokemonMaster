package pokemonmaster.cards.Grass;

import com.evacipated.cardcrawl.mod.stslib.damagemods.DamageModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.PiercingDamage;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Phantump extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Phantump",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 4;



    public Phantump() {
        super(cardInfo,new Trevenant(),new Trevenant(),CustomTags.GRASS);
        setDamage(DAMAGE, UPG_DAMAGE);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackGrass.png","pokemonmaster/character/cardback/bg_attackGrass_p.png");
        DamageModifierManager.addModifier(this, new PiercingDamage());
    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Phantump();
    }
}

