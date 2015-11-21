/*
 * Copyright (C) Christian Katzorke <ckatzorke@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.katzorke.recaptcha;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author Christian Katzorke ckatzorke@gmail.com
 *
 */
public class ReCaptchaBackendValidationResponse {

	boolean success;
	@JsonProperty("error-codes")
	String[] errorCodes;
	
	
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}


	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}


	/**
	 * @return the errorCodes
	 */
	public String[] getErrorCodes() {
		return errorCodes;
	}


	/**
	 * @param errorCodes the errorCodes to set
	 */
	public void setErrorCodes(String[] errorCodes) {
		this.errorCodes = errorCodes;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReCaptchaBackendValidationResponse [success=" + success + ", errorCodes=" + Arrays.toString(errorCodes)
				+ "]";
	}
	
	

}
