# K Palindromes
## Difficulty: Hard
<div class="problems_problem_content__Xm_eO"><p><span style="font-size: 14pt;">You are given two integers <strong>k </strong>and <strong>n</strong>. </span></p>
<p><span style="font-size: 14pt;">A string is considered as a <strong>k-palindrome</strong>&nbsp;if:</span></p>
<ul>
<li><span style="font-size: 14pt;">It is a <strong>palindrome</strong>.</span></li>
<li><span style="font-size: 14pt;">Each character in the string is one of the <strong>first&nbsp;</strong><strong>k </strong>lowercase English letters. For example, the lowercase alphabet characters for <strong>k = 4</strong> are <strong>a, b, c</strong> and <strong>d</strong>.</span></li>
</ul>
<p><span style="font-size: 14pt;">The&nbsp;k-palindromes are ordered in the following way:</span></p>
<ul>
<li><span style="font-size: 14pt;">Strings with shorter lengths come <strong>before</strong> longer strings.</span></li>
<li><span style="font-size: 14pt;">Among strings of the same length, they are sorted in <strong>lexicographical order</strong>.</span></li>
</ul>
<p><span style="font-size: 14pt;">Your task is to find&nbsp;<strong>n-th</strong> k-palindrome string.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>k = 3, n = 5
<strong>Output: </strong>bb<strong>
Explanation: </strong>For k = 3, first 5 k-palindromes in order are: a, b, c, aa, bb.<br></span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>k = 2, n = 7
<strong>Output:</strong> bab<strong>
Explanation: </strong>For k = 2, first 7 k-palindromes in order are: a, b, aa, bb, aaa, aba, bab.</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong></span></p>
<ul>
<li><span style="font-size: 14pt;">2 ≤ k ≤ 26</span></li>
<li><span style="font-size: 14pt;">1 ≤ n ≤ 10<sup>15</sup></span></li>
</ul></div>