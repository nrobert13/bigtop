/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.bigtop.bigpetstore.datagenerator.generators.products.rules;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.bigtop.bigpetstore.datagenerator.datamodels.Product;

public class AndRule implements Rule
{
	List<Rule> rules;

	public AndRule(Rule rule1, Rule rule2, Rule ... rules)
	{
		this.rules = new LinkedList<Rule>(Arrays.asList(rules));
		this.rules.add(rule1);
		this.rules.add(rule2);
	}

	@Override
	public boolean ruleMatches(Product product) throws IllegalArgumentException
	{
		boolean matches = true;
		for(Rule rule : rules)
		{
			if(! rule.ruleMatches(product))
			{
				matches = false;
			}
		}

		return matches;
	}

}
