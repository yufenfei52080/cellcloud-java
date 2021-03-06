/*
-----------------------------------------------------------------------------
This source file is part of Cell Cloud.

Copyright (c) 2009-2012 Cell Cloud Team (www.cellcloud.net)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
-----------------------------------------------------------------------------
*/

package net.cellcloud.talk;

/** 服务故障描述类。
 * 
 * @author Jiangwei Xu
 */
public final class TalkServiceFailure {

	private int code = 0;
	private String reason = null;
	private String description = null;
	private String sourceDescription = "";
	private String sourceCelletIdentifier = "";

	public TalkServiceFailure(int code, Class<?> clazz) {
		construct(code, clazz);
	}

	private void construct(int code, Class<?> clazz) {
		this.code = code;
		this.reason = "Error in " + clazz.getName();

		switch (code) {
		case TalkFailureCode.NOTFOUND_CELLET:
			this.description = "Server can not find specified cellet";
			break;
		case TalkFailureCode.CALL_TIMEOUT:
			this.description = "Network connecting timeout";
			break;
		default:
			this.description = "Unknown failure";
			break;
		}
	}

	public int getCode() {
		return this.code;
	}

	public String getReason() {
		return this.reason;
	}

	public String getDescription() {
		return this.description;
	}

	public String getSourceDescription() {
		return this.sourceDescription;
	}

	public void setSourceDescription(String desc) {
		this.sourceDescription = desc;
	}

	public String getSourceCelletIdentifier() {
		return this.sourceCelletIdentifier;
	}

	public void setSourceCelletIdentifier(String celletIdentifier) {
		this.sourceCelletIdentifier = celletIdentifier;
	}
}
