package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;

import static com.megacrit.cardcrawl.dungeons.AbstractDungeon.player;
import static pokemonmaster.PokemonMasterMod.makeID;

public class RotomV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RotomV",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;

    private int COUNT = 0;


    public RotomV() {
        super(cardInfo);
        tags.add(CustomTags.PSYCHIC);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        setCostUpgrade(1);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackPsychic.png","pokemonmaster/character/cardback/bg_attackPsychic_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
            if (!AbstractDungeon.player.discardPile.isEmpty()) {
                ArrayList<AbstractCard> DISPILE =  p.discardPile.group;
                ArrayList<AbstractCard> BURNPILE = new ArrayList<>();
                    for (AbstractCard i : DISPILE){
                        if (i.type == AbstractCard.CardType.STATUS) {
                            BURNPILE.add(i);


                        }
                }
                    for (AbstractCard j : BURNPILE){
                        player.discardPile.moveToExhaustPile(j);
                    }



            }
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }

    @Override
    public void applyPowers() {
        COUNT=0;
        if (!player.discardPile.isEmpty()) {
            for (AbstractCard i : player.discardPile.group) {
                if (i.type == AbstractCard.CardType.STATUS) {
                    COUNT += 1;
                }
                this.baseDamage = COUNT*DAMAGE;
        }
        if (player.discardPile.isEmpty()){
            this.baseDamage=0;
        }
        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription += cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
    }}

    @Override
    public AbstractCard makeCopy() { //Optional
        return new RotomV();
    }
}

