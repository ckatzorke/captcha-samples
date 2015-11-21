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
package org.katzorke.cage;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.cage.Cage;
import com.github.cage.GCage;
import com.github.cage.YCage;

@RestController
public class CageController {

	private Cage gcage = new GCage();
	private Cage ycage = new YCage();

	@RequestMapping("/cage/gcaptcha")
	public void gcaptcha(HttpSession session, HttpServletResponse response) throws IOException {
		CaptchaToken captchaToken = new CaptchaToken(gcage.getTokenGenerator().next());
		session.setAttribute("gcageToken", captchaToken);
		OutputStream os = response.getOutputStream();
		try {
			gcage.draw(captchaToken.token, os);
		} finally {
			os.close();
		}
	}
	@RequestMapping("/cage/ycaptcha")
	public void ycaptcha(HttpSession session, HttpServletResponse response) throws IOException {
		CaptchaToken captchaToken = new CaptchaToken(ycage.getTokenGenerator().next());
		session.setAttribute("ycageToken", captchaToken);
		OutputStream os = response.getOutputStream();
		try {
			ycage.draw(captchaToken.token, os);
		} finally {
			os.close();
		}
	}

	@RequestMapping("/cage/gvalidate")
	public boolean gvalidate(HttpSession session, @RequestParam("token") String actualToken) {
		CaptchaToken expectedToken = (CaptchaToken) session.getAttribute("gcageToken");
		System.out.println("Expected: " + expectedToken.token + ", actual=" + actualToken);
		return expectedToken.token.equals(actualToken);
	}
	
	@RequestMapping("/cage/yvalidate")
	public boolean yvalidate(HttpSession session, @RequestParam("token") String actualToken) {
		CaptchaToken expectedToken = (CaptchaToken) session.getAttribute("ycageToken");
		System.out.println("Expected: " + expectedToken.token + ", actual=" + actualToken);
		return expectedToken.token.equals(actualToken);
	}

}
