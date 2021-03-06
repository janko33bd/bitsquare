/*
 * This file is part of Bitsquare.
 *
 * Bitsquare is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bitsquare is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bitsquare. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bitsquare.gui.util.validation;

import io.bitsquare.locale.BSResources;

public final class PasswordValidator extends InputValidator {

    private ValidationResult externalValidationResult;

    @Override
    public ValidationResult validate(String input) {
        ValidationResult result = validateIfNotEmpty(input);
        if (result.isValid)
            result = validateMinLength(input);

        if (externalValidationResult != null && !externalValidationResult.isValid)
            return externalValidationResult;

        return result;
    }

    public void setExternalValidationResult(ValidationResult externalValidationResult) {
        this.externalValidationResult = externalValidationResult;
    }

    private ValidationResult validateMinLength(String input) {
        if (input.length() < 8)
            return new ValidationResult(false, BSResources.get("validation.passwordTooShort"));
        else if (input.length() > 50)
            return new ValidationResult(false, BSResources.get("validation.passwordTooLong"));
        else
            return new ValidationResult(true);
    }

}
