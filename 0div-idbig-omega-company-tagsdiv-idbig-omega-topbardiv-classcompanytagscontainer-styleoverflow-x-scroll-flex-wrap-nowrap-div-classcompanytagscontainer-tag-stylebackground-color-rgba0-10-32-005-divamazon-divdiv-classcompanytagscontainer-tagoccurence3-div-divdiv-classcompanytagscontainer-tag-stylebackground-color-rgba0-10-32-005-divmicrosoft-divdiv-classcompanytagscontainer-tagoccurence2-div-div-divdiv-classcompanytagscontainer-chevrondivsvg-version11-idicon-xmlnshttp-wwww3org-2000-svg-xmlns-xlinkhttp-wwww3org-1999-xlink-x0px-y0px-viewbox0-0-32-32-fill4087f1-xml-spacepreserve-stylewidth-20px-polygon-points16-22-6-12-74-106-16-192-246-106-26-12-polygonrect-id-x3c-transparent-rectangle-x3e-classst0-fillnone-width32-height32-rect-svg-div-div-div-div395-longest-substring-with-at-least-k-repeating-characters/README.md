<h2><a href="https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Amazon</div><div class="companyTagsContainer--tagOccurence">3</div></div><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Microsoft</div><div class="companyTagsContainer--tagOccurence">2</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>395. Longest Substring with At Least K Repeating Characters</a></h2><h3>Medium</h3><hr><div><p>Given a string <code>s</code> and an integer <code>k</code>, return <em>the length of the longest substring of</em> <code>s</code> <em>such that the frequency of each character in this substring is greater than or equal to</em> <code>k</code>.</p>

<p data-pm-slice="1 1 []">if no such substring exists, return 0.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "aaabb", k = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> The longest substring is "aaa", as 'a' is repeated 3 times.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "ababbc", k = 2
<strong>Output:</strong> 5
<strong>Explanation:</strong> The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of only lowercase English letters.</li>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>
</div>