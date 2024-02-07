<h2><a href="https://leetcode.com/problems/groups-of-special-equivalent-strings/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Facebook</div><div class="companyTagsContainer--tagOccurence">1</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>893. Groups of Special-Equivalent Strings</a></h2><h3>Medium</h3><hr><div><p>You are given an array of strings of the same length <code>words</code>.</p>

<p>In one <strong>move</strong>, you can swap any two even indexed characters or any two odd indexed characters of a string <code>words[i]</code>.</p>

<p>Two strings <code>words[i]</code> and <code>words[j]</code> are <strong>special-equivalent</strong> if after any number of moves, <code>words[i] == words[j]</code>.</p>

<ul>
	<li>For example, <code>words[i] = "zzxy"</code> and <code>words[j] = "xyzz"</code> are <strong>special-equivalent</strong> because we may make the moves <code>"zzxy" -&gt; "xzzy" -&gt; "xyzz"</code>.</li>
</ul>

<p>A <strong>group of special-equivalent strings</strong> from <code>words</code> is a non-empty subset of words such that:</p>

<ul>
	<li>Every pair of strings in the group are special equivalent, and</li>
	<li>The group is the largest size possible (i.e., there is not a string <code>words[i]</code> not in the group such that <code>words[i]</code> is special-equivalent to every string in the group).</li>
</ul>

<p>Return <em>the number of <strong>groups of special-equivalent strings</strong> from </em><code>words</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 
One group is ["abcd", "cdab", "cbad"], since they are all pairwise special equivalent, and none of the other strings is all pairwise special equivalent to these.
The other two groups are ["xyzz", "zzxy"] and ["zzyx"].
Note that in particular, "zzxy" is not special equivalent to "zzyx".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> words = ["abc","acb","bac","bca","cab","cba"]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 20</code></li>
	<li><code>words[i]</code> consist of lowercase English letters.</li>
	<li>All the strings are of the same length.</li>
</ul>
</div>