package Semantic.Units.Model;

import Semantic.Units.Dimension.Dimension;
import Semantic.Units.Model.Derived.DerivedUnit;
import Semantic.Units.Common.IDerivableUnit;
import Semantic.Units.SIPrefix;

import java.util.List;

/**
 * Pre-fixable Named Derived Unit. Example would be
 */
public class NamedDerivedUnit extends PrefixableUnit implements IDerivableUnit {
    private DerivedUnit derivation;

    public NamedDerivedUnit(String name, String unicodeName, String plural, String unicodePlural, String symbol, String unicodeSymbol,
                            List<SIPrefix> acceptedPrefixes, Dimension dimension, DerivedUnit derivation) {
        super(name, unicodeName, plural, unicodePlural, symbol, unicodeSymbol, acceptedPrefixes, dimension, derivation.unitSystem);
        this.derivation = derivation;
    }

    public NamedDerivedUnit(String name, String plural, String symbol, String unicodeSymbol,
                            Dimension dimension, DerivedUnit derivation) {
        super(name, plural, symbol, unicodeSymbol, dimension, derivation.unitSystem);
        this.derivation = derivation;
    }

    public DerivedUnit getDerivation() {
        return derivation;
    }

    @Override
    public Normalization getBaseNormalForm() {
        return this.derivation.getBaseNormalForm();
    }
}