<h2><a href="https://leetcode.com/problems/construct-smallest-number-from-di-string/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>2375. Construct Smallest Number From DI String</a></h2><h3>Medium</h3><hr><div><p>You are given a <strong>0-indexed</strong> string <code>pattern</code> of length <code>n</code> consisting of the characters <code>'I'</code> meaning <strong>increasing</strong> and <code>'D'</code> meaning <strong>decreasing</strong>.</p>

<p>A <strong>0-indexed</strong> string <code>num</code> of length <code>n + 1</code> is created using the following conditions:</p>

<ul>
	<li><code>num</code> consists of the digits <code>'1'</code> to <code>'9'</code>, where each digit is used <strong>at most</strong> once.</li>
	<li>If <code>pattern[i] == 'I'</code>, then <code>num[i] &lt; num[i + 1]</code>.</li>
	<li>If <code>pattern[i] == 'D'</code>, then <code>num[i] &gt; num[i + 1]</code>.</li>
</ul>

<p>Return <em>the lexicographically <strong>smallest</strong> possible string </em><code>num</code><em> that meets the conditions.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> pattern = "IIIDIDDD"
<strong>Output:</strong> "123549876"
<strong>Explanation:
</strong>At indices 0, 1, 2, and 4 we must have that num[i] &lt; num[i+1].
At indices 3, 5, 6, and 7 we must have that num[i] &gt; num[i+1].
Some possible values of num are "245639871", "135749862", and "123849765".
It can be proven that "123549876" is the smallest possible num that meets the conditions.
Note that "123414321" is not possible because the digit '1' is used more than once.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> pattern = "DDD"
<strong>Output:</strong> "4321"
<strong>Explanation:</strong>
Some possible values of num are "9876", "7321", and "8742".
It can be proven that "4321" is the smallest possible num that meets the conditions.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= pattern.length &lt;= 8</code></li>
	<li><code>pattern</code> consists of only the letters <code>'I'</code> and <code>'D'</code>.</li>
</ul>
</div>