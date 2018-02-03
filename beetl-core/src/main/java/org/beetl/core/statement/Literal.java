/*
 [The "BSD license"]
 Copyright (c) 2011-2014 Joel Li (李家智)
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.beetl.core.statement;

import org.beetl.core.Context;
import org.beetl.core.InferContext;

/** String ,Number ,Boolean 
 * @author joelli
 *
 */
public class Literal extends Expression implements Comparable
{

	public Object obj = null;
	public static final Literal NULLLiteral = new Literal(null, null);

	public Literal(Object value, GrammarToken token)
	{
		super(token);
		this.obj = value;

		// TODO Auto-generated constructor stub
	}

	@Override
	public Object evaluate(Context ctx)
	{
		return obj;
	}

	public void infer(InferContext inferCtx)
	{
		if (obj != null)
		{
			if (obj instanceof Number)
			{
				this.type = Type.NumberType;
			}
			else
			{
				this.type = new Type(obj.getClass());
			}

		}
		else
		{
			this.type = Type.NULLType;
		}

	}

	@Override
	public int compareTo(Object o)
	{
		Literal l = (Literal) o;
		Comparable a = (Comparable) this.obj;
		return a.compareTo(l.obj);

	}

	public String toString()
	{
		return obj.toString();
	}
}
